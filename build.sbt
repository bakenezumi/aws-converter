name := """aws-converter"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.0.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" %  "1.0.1"

libraryDependencies += "nu.validator.htmlparser" % "htmlparser" % "1.4"

libraryDependencies += "net.liftweb" %% "lift-json" % "2.6+"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

