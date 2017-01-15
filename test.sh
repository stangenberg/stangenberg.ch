#!/usr/bin/env bash
sbt \
  clean \
  scalafmtTest \
  coverage \
  test \
  coverageReport
