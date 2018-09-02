import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry
import java.rmi.server.UnicastRemoteObject
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    try {
        /* Instantiate the object implementation */
        val hello = Hello()
        /* exporting the object */
        val stub = UnicastRemoteObject.exportObject(hello, 0) as HelloInterface
        /* create registry and binding remote object*/
        val registry: Registry = LocateRegistry.createRegistry(1099)
        registry.bind("Hello", stub)

        println("Server is connected and ready for operation")
    } catch (e: Exception) {
        println("Server not connected: $e")
        exitProcess(1)
    }
}