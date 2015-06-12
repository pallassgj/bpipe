### Synopsis ###
<pre>var < variable name > : <default value></pre>

### Availability ###
Bpipe version 0.9.8.1

### Behavior ###
Define a variable with a default value, that can be overridden with a [Using](Using.md) construct, or by passing a value on the command line (--param option).

### Examples ###

**Say hello to earth**
```
hello = {
    var WORLD : "world"

    doc "Run hello with to $WORLD"

    exec """
        echo hello $WORLD
    """
}
run { hello }
```

**Say hello to mars**
Note that the script below is identical to the example above, except for the "run" portion.
```
hello = {
    var WORLD : "world"

    doc "Run hello with to $WORLD"

    exec """
        echo hello $WORLD
    """
}
run { hello.using(WORLD: "mars") }
```