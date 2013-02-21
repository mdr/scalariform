resolvers += Classpaths.typesafeResolver

addSbtPlugin("com.github.retronym" % "sbt-onejar" % "0.8")

resolvers += Classpaths.typesafeSnapshots
	
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")

addSbtPlugin("com.typesafe.sbtscalariform" % "sbtscalariform" % "0.5.1")

// resolvers += Resolver.url("sbt-plugin-releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

// addSbtPlugin("com.jsuereth" % "xsbt-gpg-plugin" % "0.6")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.2.0")

retrieveManaged := true

