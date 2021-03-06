name := """Athena"""
organization := "org.athena"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.0"
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws" % "2.6.10" % Test
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
libraryDependencies += ws
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0"
//libraryDependencies += "com.github.tminglei" %% "slick-pg" % "0.16.2"
//libraryDependencies += "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0"
libraryDependencies +="org.joda" % "joda-convert" % "1.7"
//libraryDependencies +="com.github.tototoshi" %% "slick-joda-mapper" % "1.2.0"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.athena.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.athena.binders._"
