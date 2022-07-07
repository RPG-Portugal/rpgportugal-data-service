package util

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.left

interface SafeCloseable {
    fun close(): Either<Throwable,Unit>
}

inline fun <T : SafeCloseable, R> T.use(block: (T) -> R): Either<Throwable,R> {
    val res = block(this)
    val closeState = close()

    closeState.map {

    }
}