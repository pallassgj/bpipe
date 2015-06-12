### Synopsis ###
<pre>output(<file name>)<br>
</pre>

### Behavior ###
The `output` function defines an explicit output for a command. It is similar to using a [Produce](Produce.md) clause but can be used inline with the definition of a command, using the form `${output(...)}`. In some situations it may be clearer to define outputs in line this way since the definition is collocated with its use. However in many cases it will be clearer to a reader if a [Produce](Produce.md) clause is used to show very clearly what outputs are created.

### Examples ###
Cause output to go to file "foo.txt"
```
  hello = {
      exec """echo world > ${output("foo.txt")}"""
  }
```