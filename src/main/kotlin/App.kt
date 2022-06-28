import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.ktorm.database.Database
import java.util.*
import javax.sql.DataSource

object App {

    @JvmStatic
    fun main() {
        createDatasource().mapCatching {
            Database.connect(it)
        }
        .mapCatching { db ->
            TODO()
        }
    }

    fun createDatasource(): Result<DataSource> =
        Result.runCatching {
            App::class.java.classLoader.getResourceAsStream("config.properties").use {
                val properties = Properties()
                properties.load(it)
                properties
            }
        }
        .mapCatching {
            val cfg  = HikariConfig(it)
            val ds = HikariDataSource(cfg)
            ds
        }

}