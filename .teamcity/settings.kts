import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*

version = "2025.11"

project {

    buildType(Project48794_B)
    buildType(Project48794_C)
    pipeline(Project48794_A)
}

object Project48794_A : Pipeline({
    id("A")
    name = "A"

    params {
        param("parA", "valA")
    }

    repositories {
        main(DslContext. settingsRoot)
    }


    dependencies {
        snapshot(Project48794_B) {
        }
        snapshot(Project48794_C) {
        }
    }
    job {
        id = "Job1"
        name = "Job1"
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
