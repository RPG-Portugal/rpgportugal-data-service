package dependency.env.prd.factory

import dependency.Factory
import dependency.Injector
import javax.sql.DataSource

class DatasourceFactory(injector: Injector) : Factory<DataSource> {

    val properties =
        injector.loadProperties("datasource.properties")

    override fun create(): Result<DataSource> {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }
}