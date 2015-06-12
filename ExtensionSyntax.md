## Introduction ##

When you use `$input` and `$output` you are asking for generic input and output file names from Bpipe, and it will give you names corresponding to defaults that it computes from the pipeline stage name. These, however, don't always end up with file extension that are very natural, and also may not be very robust because the type of file to be used is not specified. For example `$input` will refer to the _first_ output from the previous pipeline stage - but what if that stage has multiple outputs and it changes their order? Your pipeline stage will get the wrong file. To help with this, you can add file extensions to your input and your output variables:
```
  align_reads = {
     exec "bowtie –S reference $input.fastq | samtools view -bSu - > $output.bam"
  }
```
Here we have specified that this pipeline stage expects an input with file extension ".fastq" and will output a file with file extension ".bam". The first will cause Bpipe search back through previous pipeline stages to find a file ending in .fastq to provide as input. The second will ensure that the output file for this stage ends with a ".bam" file extension.  Using these file extensions is optional, but it makes your pipeline more robust.

## Multiple Inputs ##
When a pipeline stage receives multiple inputs of various kinds, you can use the _$inputs_ variable with extension syntax to filter out only those with the file extension you are interested in.

For example, to pass all the inputs ending with '.bam' to a 'merge\_bam' command:
```
  merge_bams = {
     exec "merge_bams.sh $inputs.bam"
  }
```

## Limitations ##
At the moment extension syntax only works to filter a single file extension. Hence you can't ask for _$input.fastq.gz_ - this will cause an error. For these cases you can consider using the [from](From.md) statement to match the right inputs:

```
  align_reads = {
     from("fastq.gz") {
         exec "bowtie –S reference $input.gz | samtools view -bSu - > $output.bam"
     }
  }
```

Here we can be sure we'll only match files ending in ".fastq.gz" in our bowtie command.