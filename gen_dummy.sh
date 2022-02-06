#!/usr/bin/env bash

set -e # If it fails, exit immediately.

./gradlew build # Perform build.
pushd ./app/build/outputs/apk/release/ # Change to directory.
apktool decode -f  --no-debug-info app-release-unsigned.apk # Decode APK.
find . -name '*.smali' -print -exec sed -i -e 's/Ldefpackage\//L/g' {} \; # Replace Ldefpackage with L.
popd # Return to the directory the script was called.