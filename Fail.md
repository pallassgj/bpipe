### Synopsis ###
<pre>
fail <message><br>
fail [text {<text>} | html { <html> } | report(<template>)] to <notification channel name></pre><pre>
fail [text {<text>} | html { <html> } | report(<template>)] to channel:<channel name>,<br>
subject:<subject>,<br>
file: <file to attach><br>
</pre>

### Availability ###

0.9.8.6\_beta\_2 +

### Behavior ###

Causes the current branch of the pipeline to terminate explicitly with a failure status and a provided message.

In the most simple form, a short message is provided as a string. The longer forms allow a notification or report to be generated as a result of the success.

While using `fail` as a stand alone construct is possible, the primary use case is to embed it inside the otherwise clause of a [check](Check.md) command, which ensures that Bpipe remembers the status and output of the check performed.

_Note_: see the [send](Send.md) command for more information and examples about the variants of this command that send notifications and reports.

### Examples ###

**Cause an Explicit Failure of the Pipeline**
```
   fail "Sample $branch.name has no variants - processing cannot continue"
```