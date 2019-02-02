# templates-jqwik-test

Simple test template for Java 11 / JQwik / JUnit / JavaFX projects.

## Requirements

 - OpenJDK / Oracle Java (tested with OpenJDK 11)
 - SBT (tested with SBT 1.2.8, see https://www.scala-sbt.org/)
 - Git (see https://git-scm.com/downloads/)
 - JavaFX platform files (see https://gluonhq.com/products/javafx/)

The SBT project build file downloads all further requirements:
  - JUnit 5
  - JQwik
  - OpenJFX (JavaFX)
  - other plugins

## Preparation

 - Install Java JDK, not just the JRE.
 - Install SBT and Git.
 - Install IntelliJ IDEA for IDE support
 - Install IntelliJ IDEA plugins "Git", "Gitlab projects", and "Scala".
 - Download JavaFX platform files. (unless the JDK already includes them)
 - Set the environment variables PATH and JAVAFX_HOME.
 - The environment variables might become effective only after logout/login.
 - 'git clone' this project (or download the zip from the cloud icon above)
 - Import the project from the project directory in the IDE.

## Usage

Use 'sbt run' or 'sbt test' to run the main class / tests.
Use 'sbt assembly' to build a 'fat jar' that can be started
without any dependencies.

If you want to use Eclipse/Netbeans, the project file can be exported
with command 'sbt eclipse' and 'sbt netbeans'.

## JavaFX

The build configuration also supports JavaFX.

If you use Oracle JDK 8/10, it should just work.

If you use OpenJDK 8/10/11 or Oracle JDK 11+, remember to install
OpenJFX separately.

Tested with OpenJDK 11.

## Environment variables

### JAVAFX_HOME (optional)

JAVAFX_HOME should point to a directory where one has unzipped
the platform SDK. See https://gitlab.utu.fi/jmjmak/openjfx for
further instructions.

Note: JAVAFX_HOME is not necessarily needed anymore. If you
forget to set it, the build.sbt script fetches OpenJFX for each
project separately, which can take a while.

### PATH

PATH should include both Java binaries and the SBT launcher binary
'sbt'. This is important! At least on Windows the PATH is not set
up properly by default.
