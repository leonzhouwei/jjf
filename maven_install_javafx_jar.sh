#!/bin/bash

mvn install:install-file -Dfile=/usr/lib/jvm/jdk1.7.0_25/jre/lib/jfxrt.jar -DgroupId=com.oracle.javafx -DartifactId=javafx -Dversion=2.2 -Dpackaging=jar

exit 0
