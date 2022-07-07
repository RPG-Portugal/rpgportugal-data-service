package dependency

import arrow.core.Either
import io.ktor.utils.io.core.*

interface Factory<T> : Closeable {
    fun create() : Either<Throwable,T>
}