### Synopsis ###
<pre>
check {<br>
< statements to validate results ><br>
} otherwise {<br>
<statements to execute on failure ><br>
}<br>
</pre>

<pre>
check(<check name>) {<br>
< statements to validate results ><br>
} otherwise {<br>
<statements to execute on failure ><br>
}<br>
</pre>

### Availability ###

0.9.8.6\_beta\_2 +

### Behavior ###
The _check_ statement gives a convenient way to implement validation of a pipeline's outputs or progress and implement an alternative action if the validation fails. The `check` clause is executed and any `exec` or other statements inside are processed. If one of these fails, then the `otherwise` clause executes.

The _check_ statement is stateful. Bpipe remembers the result and does not re-execute a check unless the input files are updated. Thus it is possible to implement long-running, intensive tasks to perform checks as just like normal Bpipe commands, they will not be re-executed if the pipeline is re-executed. The state is remembered by files that are created in the `.bpipe/checks` directory in the pipeline directory. Effectively, the created check file is treated as an implicit output of the `check` clause.

A convenient use of `check` is in conjunction with [success](Success.md), [fail](Fail.md) and [send](Send.md) commands.

_Note_:  a check does not have to result in aborting of the pipeline.  You may choose to do nothing in the otherwise clause of the check (it must still exist though), in which case the check is merely informational. Alternatively, the `succeed` command will cause the current branch to terminate and not produce any output files, but leave other branches running. To fail the whole pipeline, use the `fail` command.

_Note 2_: due to a quirk of Groovy syntax, the _otherwise_ command **must** be placed on the same line as the preceding curly bracket of the `check` clause.

### Examples ###

**Check that output file is non-zero length and fail the whole pipeline if it is not**
```
  check {
        exec "[ -s $output ]"
  } otherwise {
        fail "The output file had zero length"
  }
```

**Check that output file is non-zero length and terminate only this branch if it is not**
```
  check {
        exec "[ -s $output ]"
  } otherwise {
        succeed "The output file had zero length"
  }
```

**Check that output file is non-zero length and notify by email if it is not**
```
  check {
        exec "[ -s $output ]"
  } otherwise {
        send "Output file $output had zero size" to gmail
  }
```