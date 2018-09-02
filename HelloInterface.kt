import java.rmi.Remote
import java.rmi.RemoteException

interface HelloInterface : Remote {

    @Throws(RemoteException::class)
    fun say(message: String): String
}