import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "proj01",
    
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.chuusai" %% "shapeless" % "2.3.3"
    )
  )

showSuccess := false
  
  
