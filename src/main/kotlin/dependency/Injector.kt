package dependency

import arrow.core.Either
import arrow.core.getOrElse
import arrow.core.left
import java.util.*

class Injector constructor(private val properties: Properties) {

    private val classLoader = Injector::class.java.classLoader

    private var factories: Map<Class<*>, Factory<*>> = TODO()

    fun <T> inject(cls: Class<T>) : Either<Throwable,T> {
        return factories[cls]?.create() ?: left(Exception("Class Factory not found"))
    }
    fun loadProperties(name: String) : Result<Properties> {

        TODO()
    }

    fun destroy() : List<Factory<*>> {
        return factories.values.mapNotNull {
            factories = mapOf()
            Either.catch {
                it.close()
                null
            }.getOrElse {
                it
            }
        }
    }
}