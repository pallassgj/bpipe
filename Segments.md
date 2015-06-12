### Synopsis ###
<pre>segment_name = segment {<br>
< pipeline stage > + < pipeline stage > + ...<br>
<br>
}</pre>
### Behavior ###
Defines a reusable segment of a pipeline that can be made up of multiple pipeline stages.  The segment then behaves just like a normal pipeline stage itself.   This statement is useful when you have a commonly reoccurring sequence of pipeline stages that you wish to use multiple times in your pipelines, or even multiple times in a single pipeline.

### Examples ###
**Define a simple Pipeline Segment**
```
hello = {
   exec "echo hello"
}

world = {
   exec "echo world"
}

hello_world = segment {
  hello + world
}

Bpipe.run {
  hello_world
}
```