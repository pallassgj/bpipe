/*
 * Simplest possible test - just execute a couple of commands and 
 * join them together in a pipeline
 */
hello = {
	exec "echo hello "
}

run {
	[ hello ]
}
