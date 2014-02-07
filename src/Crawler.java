import graph.Graph;
import graph.GraphBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Deque;

/**
 * Program: Roaming Math Challenge
 * Author: David Tang
 */
public class Crawler {
    public static String BASE_URL = "http://www.crunchyroll.com/tech-challenge/roaming-math/dtangster@yahoo.com/";
    public static long START_EXPRESSION = 8201706;

    public static void main(String [] args) {
        GraphBuilder builder = new GraphBuilder(BASE_URL, START_EXPRESSION);
        Graph graph = builder.buildGraph();
        Deque<Long> path = graph.getShortestPath();

        // No native JSON library in Java JDK so I will manually create it
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("solution.txt")));
            StringBuffer buffer = new StringBuffer();

            buffer.append("{")
                  .append("\"goal\":").append(graph.getGoal())
                  .append(",\"node_count\":").append(graph.getNodeCount())
                  .append(",\"directed_cycle_count\":").append(graph.getCycleCount())
                  .append(",\"shortest_path\":[").append(path.pop());

            while (!path.isEmpty()) {
                buffer.append(",").append(path.pop());
            }

            buffer.append("]}");
            out.print(buffer.toString());
            out.close();
            System.out.println("Created solutions.txt");
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}
