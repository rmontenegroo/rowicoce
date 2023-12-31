package br.net.rodmonte.rowicoce

import android.util.Log
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import kotlin.random.nextUInt

data class RobotService(private val address: String, private val port: Int) {

    private val TAG = "RobotService"
    private val TIMEOUT = 5000

    fun getPort() : Int {
        return port
    }

    fun getAddress(): String {
        return address
    }

    fun sendMessage(message: String) : Boolean {

        try {

            val remoteAddress = InetAddress.getAllByName(address)[0]
            val datagram = DatagramPacket(message.toByteArray(), message.length, remoteAddress, port)
            val socket = DatagramSocket()

            socket.send(datagram)
            socket.close()
            return true

        } catch (e: Exception) {
            Log.e(TAG, "Error on sending message: $e")
        }

        return false
    }
    fun testConnection(): Boolean {

        val randomNumber = kotlin.random.Random.nextUInt().toString()
        val message = "testing:$randomNumber"

        try {

            val buf = ByteArray(message.length)
            val receivedPacket = DatagramPacket(buf, buf.size)
            val remoteAddress = InetAddress.getAllByName(address)[0]
            val datagram = DatagramPacket(message.toByteArray(), message.length, remoteAddress, port)
            val socket = DatagramSocket()

            socket.send(datagram)
            socket.soTimeout = TIMEOUT
            socket.receive(receivedPacket)
            socket.close()

            if (String(receivedPacket.data, 0, buf.size) == message) {
                return true
            }

        } catch (e: java.net.SocketTimeoutException) {
            Log.e(TAG, "Connection has timed out")
        } catch (e: Exception) {
            Log.e(TAG, "An unexpected error has occurred: $e")
        }

        return false
    }
}
