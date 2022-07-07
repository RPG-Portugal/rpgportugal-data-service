package util

import arrow.core.Either
import java.io.Closeable

object SafeCloseableExt {

    fun test() {
        val o = object : Closeable {
            override fun close(): Either<Throwable, Unit> {
                TODO("Not yet implemented")
            }
        }

        o.use {  }


    }

    fun <T : SafeCloseable, O> T.use(run: (T) -> O) : Either<Throwable,O> {
        Either.catch {
            run(this)
        }
        .map { v ->
            close().map {
                v
            }
        }
    }
}