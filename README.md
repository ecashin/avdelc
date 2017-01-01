# AVDELC

# Initial setup

In IntelliJ IDEA, I went to the file menu and created a new project.
I selected a Maven project type, using the 1.8 java SDK that I had
previously installed.  I had also previously pointed out that SDK to
IntelliJ.

I chose a directory for the project, and then IntelliJ opened Maven's
configuration file, pom.xml.

I edited the "pom file" using tricks I learned by Googling.  I want to
add a library that can parse CSV, and I found one in the Apache
Commons.

https://commons.apache.org/proper/commons-csv/

I Google for "apache commons csv maven" to find the dependency stanza
that I need to add to my pom file.  The info is at the URL below.

https://mvnrepository.com/artifact/org.apache.commons/commons-csv/1.4

I add the snippet of XML from that page to my pom file.  IntelliJ
knows enough about Maven to suggest that I enable auto-import of the
pom file.  I do that, and then IntelliJ configures itself to reflect
the configuration in the pom file, recognizing Apache commons CSV
library as a dependency.

IntelliJ has already created a project skeleton, so I use the project
structure on the left of the IDE to get to src/main/java.  Then I use
the file menu to create a new java package, "avdelc".

Right clicking the new package selected on the left, I create a new
Java class, "CSVReader".

To let Maven know that we're using 1.8, I Google for "maven source
plugin" to recall the XML I need.  It's the maven-compiler-plugin.

I Google for "build jar with dependencies maven" to recall information
about the right Maven plugin to use, and I add a build section to the
pom file.  Running `mvn package` and then `mvn assembly:single` on the
command line builds a
`target/avdelc-csv-1.0-SNAPSHOT-jar-with-dependencies.jar` that can be
run as shown below.

    ecashin@montgomery:~/git/avdelc/csv$ echo a,b,c | java -jar target/avdelc-csv-1.0-SNAPSHOT-jar-with-dependencies.jar
    1: 1: a
    1: 2: b
    1: 3: c
    ecashin@montgomery:~/git/avdelc/csv$ 