import scalariform.formatter.preferences._

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

publishMavenStyle := false

scriptedSettings

scriptedLaunchOpts <+= version apply { v => "-Dproject.version="+v }

Release.settings

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignParameters, false)
  .setPreference(FormatXml, true)
  .setPreference(SpaceInsideBrackets, false)
  .setPreference(IndentWithTabs, false)
  .setPreference(SpaceInsideParentheses, false)
  .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(CompactStringConcatenation, false)
  .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, false)
  .setPreference(IndentPackageBlocks, true)
  .setPreference(CompactControlReadability, false)
  .setPreference(SpacesWithinPatternBinders, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 40)
  .setPreference(DoubleIndentClassDeclaration, false)
  .setPreference(PreserveSpaceBeforeArguments, false)
  .setPreference(SpaceBeforeColon, false)
  .setPreference(RewriteArrowSymbols, false)
  .setPreference(IndentLocalDefs, false)
  .setPreference(IndentSpaces, 2)
  //.setPreference(AreserveDanglingCloseParenthesis, true)

