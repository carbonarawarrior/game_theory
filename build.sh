#!/bin/bash

mkdir -p out
javac -d out src/com/game/*.java
jar cfm game.jar manifest.txt -C out .
