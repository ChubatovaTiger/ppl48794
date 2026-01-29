import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.11"

project {

    buildType(Project48794_B)
    buildType(Project48794_C)
    buildType(Project48794_A)
}

object Project48794_A : BuildType({
    id("A")
    name = "A"

    params {
        param("parA", "valA")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    features {
        perfmon {
        }
    }

    dependencies {
        snapshot(Project48794_B) {
        }
        snapshot(Project48794_C) {
        }
    }
})

object Project48794_B : BuildType({
    id("B")
    name = "B"

    params {
        param("parB", "valB1")
    }

    vcs {
        root(DslContext.settingsRoot, "+:folderB => .")

        cleanCheckout = true
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "ls"
        }
    }

    features {
        perfmon {
        }
    }
})

object Project48794_C : BuildType({
    id("C")
    name = "C"

    params {
        param("parC", "valC")
    }

    vcs {
        root(DslContext.settingsRoot, "+:folderC => .")

        cleanCheckout = true
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "ls"
        }
    }

    features {
        perfmon {
        }
    }
})
