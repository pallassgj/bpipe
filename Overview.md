## Introduction ##

Bpipe is two things:

  * A small language for defining pipeline stages and linking them together to make pipelines
  * A utility for running and managing the pipelines you define

Bpipe does not replace the commands you run within your pipeline, but rather it helps you to run them better - more safely, more reliably and more conveniently.

## The Bpipe Language ##

The Bpipe language is a minimal syntax for declaring how to run your pipeline stages.  Bpipe is actually a [Domain Specific Language](http://en.wikipedia.org/wiki/Domain-specific_language) based on Groovy, a scripting language that inherits syntax from Java.  All Bpipe scripts are valid Groovy scripts, and most Java syntax works in Bpipe scripts.  However you don't need to know either Java or Groovy to use Bpipe.

For Bpipe to run your pipeline you need to give each part of the pipeline (each _stage_) a name.  In Bpipe naming a pipeline stage looks like this:
```
stage_name = {
  exec "shell command to execute your pipeline stage"
}
```
The shell command is the same command you would run from the command line to execute that part of your pipeline, placed in quotes.

You can define many pipeline stages in one file:
```
stage_one = {
  exec "shell command to execute stage one"
}

stage_two = {
  exec "shell command to execute stage two"
}
```

Once you define your pipeline stages you can build and run your pipeline by _joining_ the stages using the _plus_ operator:
```
Bpipe.run {
 stage_one + stage_two
}
```
Putting this all together, here is the whole Bpipe script:
```
stage_one = {
  exec "shell command to execute stage one"
}

stage_two = {
  exec "shell command to execute stage two"
}

Bpipe.run {
 stage_one + stage_two
}
```

## The Bpipe Command Line Utility ##
Bpipe comes with a tool to run and manage your scripts called _bpipe_ (surprise!).  The most basic use of the bpipe command is to run your pipelines.   To do that, you simply save your pipeline definition in a file and then run the pipeline:
```
  bpipe run your_pipeline_file
```

The bpipe command line tool can perform other functions that are useful for managing your pipeline as well:

To rerun the last pipeline that was run in the local directory from where it left off:
```
  bpipe retry
```

To see what a pipeline will do without actually executing it:
```
  bpipe test your_pipeline_file
```

To see the history of jobs run in the local directory:
```
  bpipe history
```

To see what bpipe jobs you currently have running:
```
  bpipe jobs
```

## Next Steps ##
To learn more about how Bpipe works, take a look at the [Tutorial](GettingStarted.md) where you can work through creating a very simple pipeline .  Or if you are already comfortable with the basics of how bpipe is working you can jump straight to an example of a [real bioinformatics pipeline](RealPipelineTutorial.md).