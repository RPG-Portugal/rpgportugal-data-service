package dependency.env.prd

import com.zaxxer.hikari.HikariConfig
import dependency.module.DependencyModule
import dependency.Injector
import java.util.*

class PrdModule : DependencyModule {
    private val properties: Lazy<Result<HikariConfig>> = lazy {
        Result.runCatching {
            val properties = Properties()
            Injector::class.java.classLoader.getResourceAsStream(
                "config.properties"
            )
            .use {
                properties.load(it)
                properties
            }
        }
        .mapCatching(::HikariConfig)
    }



}