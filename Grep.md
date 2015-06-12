### Synopsis ###
<pre>
grep(<regular expression>) {<br>
< statements that execute for each line matching expression ><br>
}<br>
</pre>

or

<pre>
grep(<regular expression>)<br>
</pre>

### Behavior ###
The _grep_ statement is an internal convenience function that processes the input file line by line for each line matching a given regular expression.

In the first form, the body is executed for each line in the input file that matches and an implicit variable _line_ is defined.  The body can execute regular commands using [exec](Exec.md) or it can use native Groovy / Java commands to process the data.  An implicit variable _out_ is defined as an output stream that can write to the current output file, making it convenient to use _grep_ to filter and process lines and write extracted data to the output file.

In the second form _grep_ works very much like the command line grep with both the input and output file taken from the _input_ and _output_ variables.   In this case, all matching lines from the input are written to the output.

### Examples ###

**Remove lines containing INDEL from a file**
```
grep(".*") {
  if(line.indexOf("INDEL") < 0)
    out << line
}
```

**Create output file containing only INDELS from input file**
```
grep("INDEL")
```
