import java.rmi.registry.LocateRegistry
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    try {
        /* get the registry */
        val registry = LocateRegistry.getRegistry(1099)
        val hello = registry.lookup("Hello") as HelloInterface

        val message = args.getOrNull(0) ?: "No Args"
        println(hello.say(message))
    } catch (e: Exception) {
        println("HelloClient exception: $e")
        exitProcess(1)
    }
}
