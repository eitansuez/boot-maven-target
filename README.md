# Example boot project illustrating use of sourceCompatibility.

## Assumptions

* You have openjdk-11 installed on your machine and `$JAVA_HOME/bin` is in your `$PATH`

## java 8 compatibility

#### Given
 
Note in `pom.xml` the following property:

```
<java.version>1.8</java.version>
```

The above property is specific to Spring boot to set both the java compiler `source` and `target` versions.  For Spring Boot projects, that's all you need.

For java projects that do not use Spring Boot, you should set these maven properties:

```
<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>
```

### When

Build the project:

```
$ mvn clean package
```

### Then

Test the java version of a generated class file:

```
javap -v ./target/classes/com/eitan/bootmaventarget/HelloController.class | grep major
```

The output should be:

```
major version: 52
``` 

## java 11 compatibility

Edit `pom.xml` and set all properties to `11`:

```
<java.version>11</java.version>
<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>
```

Then, repeat the above steps:

1. Do a clean build
2. Re-run javap
3. The output should now state `major version: 55`

Again, for a Boot project, all you need is the one `java.version` property.  The other two properties can be deleted.  And vice versa:  for a non-Boot project, `java.version` is undefined, and you should use the two `maven.compiler.source` and `maven.compiler.target` properties instead.
