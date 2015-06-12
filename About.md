### Synopsis ###
<pre>
about title: <title for pipeline><br>
</pre>


### Behavior ###
The _about_ statement defines pipeline level documentation for a pipeline file.  It can be used any where at the top level of a pipeline file.  At the moment, _title_ is the only supported attribute for pipeline documentation.

Pipeline documentation is used in the HTML report that can be generated using the [run](run.md) command.

### Examples ###

**Add a title to a pipeline**
```
about title: "Exome Variant Calling Pipeline"

run { align_bwa + picard_dedupe + gatk_call_variants }
```