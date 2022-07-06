#!/bin/bash
JARFILE=$( ls target | grep  jar)
if [ -n "$JARFILE " ]
then
  echo "file exists, with name: $JARFILE . now copying over!"
  cp "target/$JARFILE"* ../javaJar/parsePDF.jar
  echo "proof"
  ls -al ../javaJar
fi
#.


