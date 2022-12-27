//scalaVersion := "2.13.8"
//version := "1.0"
//name := "message_broker"
//
//val AkkaVersion = "2.6.8"
//libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion

ThisBuild / scalaVersion := "2.13.10"

val AkkaVersion = "2.7.0"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
)
lazy val root = (project in file("."))
  .settings(
    name := "message_broker"
  )