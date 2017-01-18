name := """stangenberg.ch"""

lazy val root = (project in file(".")).enablePlugins(PlayScala, SbtWeb)

scalaVersion := "2.11.8"

resolvers ++= Seq(
  Resolver.typesafeIvyRepo("releases")
)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.adrianhurt" %% "play-bootstrap" % "1.1-P25-B3",
  "org.webjars" % "bootstrap-datepicker" % "1.4.0",
  "com.github.racc" % "typesafeconfig-guice" % "0.0.3",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _ )

pipelineStages := Seq(digest, gzip)

includeFilter in (Assets, LessKeys.less) := "*.less"

excludeFilter in (Assets, LessKeys.less) := "_*.less"

parallelExecution in Test := false

fork in Test := false
fork in run := false