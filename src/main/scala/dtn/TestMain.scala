package dtn

import dtn.Dtn7RsWsConn

import scala.concurrent.ExecutionContext.Implicits.global
import dtn2.PrimaryBLock
import dtn2.DestinationSpecificPart.{DTN, DTN_NONE}

import io.bullet.borer.{Codec, Json}

@main def run(): Unit = {

  val block = PrimaryBLock(7, 0, 0, 1, DTN("//node1/incoming"), 1, DTN("//node1/incoming"), 1, DTN_NONE(), 0, 1, 2)
  
  println(Json.encode(block).toUtf8String)
  
  /*
  Dtn7RsWsConn.create().map(conn => {
    println(s"connected to node: ${conn.nodeId.get}")

    if (conn.nodeId.get.startsWith("ipn")) throw Exception("DTN mode IPN is unsupported by this client")

    val cRDTGroupEndpoint = "dtn://global/crdt/~app1"

    conn.registerEndpointAndSubscribe(cRDTGroupEndpoint).flatMap(_ => {
      val bundle = Bundle.createWithUTF8TextAsData(
        src = cRDTGroupEndpoint,
        dst = cRDTGroupEndpoint,
        strng = "Hello World",
        lifetime = 3600 * 24 * 1000,
        delivery_notification = false
      )

      println(s"start sending bundle with text: ${bundle.getDataAsUTF8Text}")
      conn.sendBundle(bundle).flatMap(response => {
        println(s"finished sending bundle, response: ${response}")
        println(s"start receiving bundle")
        conn.receiveBundle()
      }).flatMap(response => {
        println(s"received bundle with text: ${response.getDataAsUTF8Text}")
        conn.disconnect()
      })
    })
  })
  */
}