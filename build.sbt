val sharedSettings = Seq(
  scalaVersion := "3.3.3", 
  resolvers += "jitpack" at "https://jitpack.io",
  libraryDependencies ++= Seq(
      "com.github.rescala-lang.rescala" %%% "rescala"     % "71e3cee000",
      "com.github.rescala-lang.rescala" %%% "kofre"       % "71e3cee000",
      "org.scala-js"                    %%% "scalajs-dom" % "2.8.0",
      "com.lihaoyi"                     %%% "scalatags"   % "0.12.0",
      // Below imports are required for the restoration and distribution.
      "com.github.scala-loci.scala-loci"      %%% "scala-loci-communicator-webrtc"       % "b9809c9c2d",
      "com.github.scala-loci.scala-loci"      %%% "scala-loci-serializer-jsoniter-scala" % "b9809c9c2d",
      "com.github.plokhotnyuk.jsoniter-scala" %%% "jsoniter-scala-core"                  % "2.27.7",
      "com.github.plokhotnyuk.jsoniter-scala"  %% "jsoniter-scala-macros"                % "2.27.7",
      "com.softwaremill.sttp.client4"         %%% "core"                                 % "4.0.0-M9",
      "com.softwaremill.sttp.client4"          %% "okhttp-backend"                       % "4.0.0-M9",
      "io.bullet" %% "borer-core" % "1.14.0",
      "io.bullet" %% "borer-derivation" % "1.14.0"
    ),
)

lazy val chat =
  // select supported platforms
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure).in(file(".")) // [Pure, Full, Dummy], default: CrossType.Full
    .settings(sharedSettings)
    .jsSettings(
      scalaVersion := "3.3.3" 
    )
    .jvmSettings(
      scalaVersion := "3.3.3"
    )
