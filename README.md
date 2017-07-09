# Sbt Plugin Example

## Development

1. build plugin locally
`sbt sbt-plugin-example/publishLocal`

2. use published plugin in sample-project
```
cd sample-project
sbt compile
> genDemo
> test:genDemo
```
