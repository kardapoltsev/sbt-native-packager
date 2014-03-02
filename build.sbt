sbtPlugin := true

sbtVersion in Global := {
  scalaBinaryVersion.value match {
    case "2.10" => "0.13.0"
    case "2.9.2" => "0.12.4"
  }
}

scalaVersion in Global := "2.9.2"

crossScalaVersions := Seq("2.9.2", "2.10.2")

name := "sbt-native-packager"

organization := "com.typesafe.sbt"

scalacOptions in Compile += "-deprecation"

libraryDependencies += "org.apache.commons" % "commons-compress" % "1.4.1"

site.settings

com.typesafe.sbt.SbtSite.SiteKeys.siteMappings <+= (baseDirectory) map { dir => 
  val nojekyll = dir / "src" / "site" / ".nojekyll"
  nojekyll -> ".nojekyll"
}

site.sphinxSupport()

ghpages.settings

git.remoteRepo := "git@github.com:sbt/sbt-native-packager.git"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := Some(Resolver.url("Frumatic snapshots", url("http://nexus.frumatic.com/content/repositories/snapshots"))(Resolver.ivyStylePatterns))

publishMavenStyle := false

scriptedSettings

scriptedLaunchOpts <+= version apply { v => "-Dproject.version="+v }

Release.settings





