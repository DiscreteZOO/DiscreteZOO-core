package xyz.discretezoo.core.graphs

import scala.collection.mutable

/**
  * Created by katja on 11/12/15.
  */
class AdjacencyListBuilder {

  val verticesByIds = mutable.Map[Long, LabelledVertexNeighbourhood]()

  def addEdge(vertexNo1: Long, vertexNo2: Long): Unit = {
    val vertex1 = verticesByIds.getOrElseUpdate(vertexNo1, new LabelledVertexNeighbourhood(vertexNo1))
    val vertex2 = verticesByIds.getOrElseUpdate(vertexNo2, new LabelledVertexNeighbourhood(vertexNo2))
    vertex1.addNeighbour(vertex2)
    vertex2.addNeighbour(vertex1)
  }

  def getMap: Map[Long, LabelledVertexNeighbourhood] = verticesByIds.toMap

}
