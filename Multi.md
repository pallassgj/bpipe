### Synopsis ###
<pre>
multi <command>,<command>...<br>
<br>
multiExec <Groovy list of commands><br>
<br>
</pre>

### Availability ###
0.9.8+

### Behavior ###
The _multi_ statement executes multiple commands in parallel and waits for them all to finish. If any of the commands fail the whole pipeline stage fails, and all the failures are reported.

Generally you will want to use Bpipe's built in [parallelization](ParallelTasks.md) features to run multiple commands in parallel. However sometimes that may not fit how you want to model your pipeline stages. The _multi_ statement let's you perform small-scale parallelization inside your pipeline stages.

_Note_: if you wish to pass a computed list of commands to _multi_, use the form _multiExec_ instead (see example below).

### Examples ###
**Using comma delimited list of commands**

```
hello = {
  multi "echo mars > $output1.txt",
        "echo jupiter > $output2.txt",
        "echo earth > $output3.txt"
}
```

**Computing a list of commands**

```
hello = {  
        // Build a list of commands to execute in parallel
        def outputs = (1..3).collect { "out${it}.txt" }

        // Compute the commands we are going to execute
	int n = 0
        def commands =["mars","jupiter","earth"].collect{"echo $it > ${outputs[n++]}"} 

        // Tell Bpipe to produce the outputs from the commands
	produce(outputs) {
	    multiExec commands
	}
}

run { hello }
```

