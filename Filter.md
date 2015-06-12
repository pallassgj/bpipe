## Filter ##

### Synopsis ###
<pre>filter(<filter name>) {<br>
< statements to filter inputs ><br>
<br>
}</pre>
### Behavior ###
Filter is a convenient alias for [produce](Produce.md) where the name of the output or outputs is deduced from the name of the input(s) by keeping the same file extension but adding a new tag to the file name.   For example, if you have a command that removes comment lines from a CSV file _foo.csv_, you can easily declare a section of your script to produce output _foo.nocomments.csv_ by declaring a filter with name "nocomments".  In general you will use filter where you are keeping the same format for the data but performing some operation on the data.

The output(s) that are automatically deduced by _filter_ will inherit all the behavior implied by the [produce](Produce.md) statement.

### Annotation ###
You can also declare a whole pipeline stage as a filter by adding the Filter annotation prior to the stage in the form `@Filter(<filter name>)`.

### Examples ###
**Remove Comment Lines from CSV File**
```
filter("nocomments") {
  exec """
    grep -v '^#' $input > $output
  """
}
```