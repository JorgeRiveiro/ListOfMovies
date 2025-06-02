pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ListOfMovies"
include(":app")
include(":domain:movie")
include(":domain:region")
include(":feature:common")
include(":feature:detail")
include(":feature:home")
include(":framework:core")
include(":framework:movie")
include(":framework:region")
