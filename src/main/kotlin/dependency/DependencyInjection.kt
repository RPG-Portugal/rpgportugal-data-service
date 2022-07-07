package dependency

import arrow.core.Either
import arrow.core.computations.either
import arrow.core.flatMap
import java.util.*

object DependencyInjection {

    suspend fun <T> use(scope: (injector: Injector) -> T): Either<Throwable, T> =
        either {

            val injector =
                loadProperties()
                    .flatMap(::initFactories)
                    .bind()

            val result =
                Either.catch { scope(injector) }.bind()

            result
        }

    private fun loadProperties() : Either<Throwable, Properties> {
        return Either.catch {
            val properties = Properties()
            DependencyInjection::class.java.classLoader.getResourceAsStream("")?.let {
                properties.load(it)
            }
            properties
        }
    }

    private fun createInjector(factories: Map<Class<*>, Factory<*>>) : Either<Throwable, Injector> {
        TODO()
    }

    private fun initFactories(properties: Properties): Either<Throwable, Map<Class<*>, Factory<*>>> {
        TODO("Not yet implemented")
    }

    private fun close(): Either<Throwable,Unit> {
        return Either.catch {
            factories.forEach {
                it.close()
            }
        }
    }

}