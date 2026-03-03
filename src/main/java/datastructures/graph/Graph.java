package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public Map<String, ArrayList<String>> getGraph() {
        return adjList;
    }

    public boolean addVertex(String value) {
        if (!adjList.containsKey(value)) {
            adjList.put(value, new ArrayList<String>());

            return true;
        }

        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);

            return true;
        }

        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (!adjList.get(vertex1).isEmpty() && !adjList.get(vertex2).isEmpty()) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);

            return true;
        }

        return false;
    }

    public boolean removeVertex(String vertex) {
        if (!adjList.containsKey(vertex)) return false;

        for (String otherVertex : adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }

        adjList.remove(vertex);

        return true;
    }
}