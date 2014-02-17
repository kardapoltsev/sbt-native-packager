sbtPlugin := true

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
Bintray.settings

publishMavenStyle := false

scriptedSettings

scriptedLaunchOpts <+= version apply { v => "-Dproject.version="+v }

Release.settings





