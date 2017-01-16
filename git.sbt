enablePlugins(GitVersioning, GitBranchPrompt)

git.useGitDescribe := true
git.baseVersion := "0.0.0"
showCurrentGitBranch

val VersionRegex = "v([0-9]+.[0-9]+.[0-9]+)-?(.*)?".r
git.gitTagToVersionNumber := {
  case VersionRegex(v,"") => Some(v)
  case VersionRegex(v,"SNAPSHOT") => Some(s"$v")
  case VersionRegex(v,s) => Some(s"$v-$s")
  case _ => None
}
