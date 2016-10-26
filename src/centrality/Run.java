package centrality;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;


public class Run {

	static int edgeCount_Directed = 0; // This works with the inner MyEdge class

	class MyNode {
		// static int edgeCount = 0; // This works with the inner MyEdge class
		String id;

		public MyNode(String id) {
			this.id = id;
		}

		public String toString() {
			return "V" + id;
		}
	}

	class MyLink {
		double weight;
		int id;

		public MyLink(double weight) {
			this.id = edgeCount_Directed++;
			this.weight = weight;
		}

		public String toString() {
			return "E" + id;
		}
	}

	// used to construct graph and call graph algorithm used in JUNG
	public void BetweenNess_Centrality_Score(LinkedList<String> Distinct_nodes, LinkedList<String> source_vertex, LinkedList<String> target_vertex, LinkedList<Double> Edge_Weight)
	{
		//CREATING weighted directed graph
	        Graph<MyNode, MyLink> g = new DirectedSparseGraph<Run.MyNode, Run.MyLink>();
	        //create node objects
	        Hashtable<String, MyNode> Graph_Nodes = new Hashtable<String, Run.MyNode>();
	        LinkedList<MyNode> Source_Node = new LinkedList<Run.MyNode>();
	        LinkedList<MyNode> Target_Node = new LinkedList<Run.MyNode>();
	        LinkedList<MyNode> Graph_Nodes_Only = new LinkedList<Run.MyNode>();
	        //LinkedList<MyLink> Graph_Links = new LinkedList<Graph_Algos.MyLink>();
	        //create graph nodes
	        for(int i=0;i<Distinct_nodes.size();i++) {
	        	String node_name = Distinct_nodes.get(i);
	        	MyNode data = new MyNode(node_name);
	        	Graph_Nodes.put(node_name, data);
	        	Graph_Nodes_Only.add(data);
	        }
	        //Now convert all source and target nodes into objects
	        for(int t=0;t<source_vertex.size();t++) {
		        Source_Node.add(Graph_Nodes.get(source_vertex.get(t)));
		        Target_Node.add(Graph_Nodes.get(target_vertex.get(t)));
	        }
	        //Now add nodes and edges to the graph
	        for(int i=0;i<Edge_Weight.size();i++) {
	        	g.addEdge(new MyLink(Edge_Weight.get(i)),Source_Node.get(i), Target_Node.get(i), EdgeType.DIRECTED);
	        }
	        
	        Transformer<MyLink, Double> wtTransformer = new Transformer<MyLink,Double>() { 
	        	public Double transform(MyLink link) { 
	        		return link.weight;  
	            }
	        };
	        
	        edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality<MyNode,MyLink> BC1 =
	        		new edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality<MyNode, MyLink>(g);
	        //Calculating Betweenness Centrality score of nodes
	        for(int i=0;i<Graph_Nodes_Only.size();i++) {
	        	System.out.println("Graph Node "+Graph_Nodes_Only.get(i)+" Betweenness Centrality " + BC1.getVertexScore(Graph_Nodes_Only.get(i)));
	        }
	        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// let the nodes of graph are: {A, B, C, D, E, F, G}
		// Directed edges are: {AB=0.7, BC=0.9, CD=0.57, DB=1.0, CA=1.3, AD=0.3,
		// DF=0.2, DE=0.8, EG=0.4, FE=0.6, GF=0.2}

		Run r = new Run();

		LinkedList<String> Distinct_Vertex = new LinkedList<String>();
		LinkedList<String> Source_Vertex = new LinkedList<String>();
		LinkedList<String> Target_Vertex = new LinkedList<String>();
		LinkedList<Double> Edge_Weight = new LinkedList<Double>();

		// add the distinct vertexes
//		Distinct_Vertex.add("A");
//		Distinct_Vertex.add("B");
//		Distinct_Vertex.add("C");
//		Distinct_Vertex.add("D");
//		Distinct_Vertex.add("E");
//		Distinct_Vertex.add("F");
//		Distinct_Vertex.add("G");
//
//		Source_Vertex.add("A");	Target_Vertex.add("B");	Edge_Weight.add(0.7);
//		Source_Vertex.add("B");	Target_Vertex.add("C");	Edge_Weight.add(0.9);
//		Source_Vertex.add("C");	Target_Vertex.add("D");	Edge_Weight.add(0.57);	
//		Source_Vertex.add("D");	Target_Vertex.add("B");	Edge_Weight.add(1.0);	
//		Source_Vertex.add("C");	Target_Vertex.add("A");	Edge_Weight.add(1.3);	
//		Source_Vertex.add("A");	Target_Vertex.add("D");	Edge_Weight.add(0.3);	
//		Source_Vertex.add("D");	Target_Vertex.add("F");	Edge_Weight.add(0.2);	
//		Source_Vertex.add("D"); Target_Vertex.add("E"); Edge_Weight.add(0.8);
//		Source_Vertex.add("E");	Target_Vertex.add("G");	Edge_Weight.add(0.4);	
//		Source_Vertex.add("F");	Target_Vertex.add("E");	Edge_Weight.add(0.6);	
//		Source_Vertex.add("G");	Target_Vertex.add("F");	Edge_Weight.add(0.2);
		
		// add the distinct vertexes
		for(int i = 0; i < 115; i++) {
			Distinct_Vertex.add("p"+i);
		}
		
		LinkedList<String> c0_Distinct_Vertex = new LinkedList<String>();
		LinkedList<String> c0_Source_Vertex = new LinkedList<String>();
		LinkedList<String> c0_Target_Vertex = new LinkedList<String>();
		LinkedList<Double> c0_Edge_Weight = new LinkedList<Double>();
		
		LinkedList<String> c1_Distinct_Vertex = new LinkedList<String>();
		LinkedList<String> c1_Source_Vertex = new LinkedList<String>();
		LinkedList<String> c1_Target_Vertex = new LinkedList<String>();
		LinkedList<Double> c1_Edge_Weight = new LinkedList<Double>();
		
		LinkedList<String> c2_Distinct_Vertex = new LinkedList<String>();
		LinkedList<String> c2_Source_Vertex = new LinkedList<String>();
		LinkedList<String> c2_Target_Vertex = new LinkedList<String>();
		LinkedList<Double> c2_Edge_Weight = new LinkedList<Double>();
		
		LinkedList<String> c3_Distinct_Vertex = new LinkedList<String>();
		LinkedList<String> c3_Source_Vertex = new LinkedList<String>();
		LinkedList<String> c3_Target_Vertex = new LinkedList<String>();
		LinkedList<Double> c3_Edge_Weight = new LinkedList<Double>();
		
		try {
			BufferedReader clusters = new BufferedReader(new FileReader("50%cluster (1).csv"));
			clusters.readLine();
			
			while(true) {
				String line = clusters.readLine();
				if(line == null) break;
				
				String t[] = line.split(",");
				
				switch(Integer.parseInt(t[1])) {
					case 0:
						c0_Distinct_Vertex.add("p"+(Integer.parseInt(t[0])-2));
						break;
					case 1:
						c1_Distinct_Vertex.add("p"+(Integer.parseInt(t[0])-2));
						break;
					case 2:
						c2_Distinct_Vertex.add("p"+(Integer.parseInt(t[0])-2));
						break;
					case 3:
						c3_Distinct_Vertex.add("p"+(Integer.parseInt(t[0])-2));
						break;
				}
			}
			clusters.close();
			
			BufferedReader links = new BufferedReader(new FileReader("nccu_epidemic_ConnectivityUpReport.txt"));
			List<Position> pos = new ArrayList<Position>();
			int c0=0,c1=0,c2=0,c3=0;
			
			while(true) {
				String line = links.readLine();
				if(line == null) break;
				
				// time CONN host_1 host_2 up
				String t[] = line.split(" ");
				String h1 = "p"+t[2], h2 = "p"+t[3];
				
				boolean isContinue = true;
				boolean found1 = false, found2 = false;
				
				for(String s : c0_Distinct_Vertex) {
					if(s.equalsIgnoreCase(h1)) found1 = true;
					if(s.equalsIgnoreCase(h2)) found2 = true;
				}
				
				if(found1 && found2) {
					c0_Source_Vertex.add(h1);
					c0_Target_Vertex.add(h2);
					boolean isFound = false;
					int i = 0;
					for(i = 0; i < pos.size(); i++) {
						if(pos.get(i).isEqual(new Position(h1, h2, 0, -1))) {
							isFound = true;
							break;
						}
					}
					
					if(isFound)
						pos.get(i).incrCount();
					else 
						pos.add(new Position(h1, h2, 0, c0++));
					
					isContinue = false;
				}
				
				if(isContinue) {
					found1 = false; found2 = false;
					
					for(String s : c1_Distinct_Vertex) {
						if(s.equalsIgnoreCase(h1)) found1 = true;
						if(s.equalsIgnoreCase(h2)) found2 = true;
					}
					
					if(found1 && found2) {
						c1_Source_Vertex.add(h1);
						c1_Target_Vertex.add(h2);
						boolean isFound = false;
						int i = 0;
						for(i = 0; i < pos.size(); i++) {
							if(pos.get(i).isEqual(new Position(h1, h2, 1, -1))) {
								isFound = true;
								break;
							}
						}
						
						if(isFound)
							pos.get(i).incrCount();
						else 
							pos.add(new Position(h1, h2, 1, c1++));
						
						isContinue = false;
					}
				}
				
				if(isContinue) {
					found1 = false; found2 = false;
					
					for(String s : c2_Distinct_Vertex) {
						if(s.equalsIgnoreCase(h1)) found1 = true;
						if(s.equalsIgnoreCase(h2)) found2 = true;
					}
					
					if(found1 && found2) {
						c2_Source_Vertex.add(h1);
						c2_Target_Vertex.add(h2);
						boolean isFound = false;
						int i = 0;
						for(i = 0; i < pos.size(); i++) {
							if(pos.get(i).isEqual(new Position(h1, h2, 2, -1))) {
								isFound = true;
								break;
							}
						}
						
						if(isFound)
							pos.get(i).incrCount();
						else 
							pos.add(new Position(h1, h2, 2, c2++));
						
						isContinue = false;
					}
				}
				
				if(isContinue) {
					found1 = false; found2 = false;
					
					for(String s : c3_Distinct_Vertex) {
						if(s.equalsIgnoreCase(h1)) found1 = true;
						if(s.equalsIgnoreCase(h2)) found2 = true;
					}
					
					if(found1 && found2) {
						c3_Source_Vertex.add(h1);
						c3_Target_Vertex.add(h2);
						boolean isFound = false;
						int i = 0;
						for(i = 0; i < pos.size(); i++) {
							if(pos.get(i).isEqual(new Position(h1, h2, 3, -1))) {
								isFound = true;
								break;
							}
						}
						
						if(isFound)
							pos.get(i).incrCount();
						else 
							pos.add(new Position(h1, h2, 3, c3++));
						
						isContinue = false;
					}
				}
			}
			links.close();
			
			for(Position p : pos) {
				switch(p.getCluster()) {
					case 0:
						c0_Edge_Weight.add((double)p.getCount());
						break;
					case 1:
						c1_Edge_Weight.add((double)p.getCount());
						break;
					case 2:
						c2_Edge_Weight.add((double)p.getCount());
						break;
					case 3:
						c3_Edge_Weight.add((double)p.getCount());
						break;
				}
			}
			
			System.out.println("cluster 0 " + c0_Distinct_Vertex.size());
			r.BetweenNess_Centrality_Score(c0_Distinct_Vertex, c0_Source_Vertex, c0_Target_Vertex, c0_Edge_Weight);
			System.out.println("\n\n");
			
			System.out.println("cluster 1 " + c1_Distinct_Vertex.size());
			r.BetweenNess_Centrality_Score(c1_Distinct_Vertex, c1_Source_Vertex, c1_Target_Vertex, c1_Edge_Weight);
			System.out.println("\n\n");
			
			System.out.println("cluster 2 " + c2_Distinct_Vertex.size());
			r.BetweenNess_Centrality_Score(c2_Distinct_Vertex, c2_Source_Vertex, c2_Target_Vertex, c2_Edge_Weight);
			System.out.println("\n\n");
			
			System.out.println("cluster 3 " + c3_Distinct_Vertex.size());
			r.BetweenNess_Centrality_Score(c3_Distinct_Vertex, c3_Source_Vertex, c3_Target_Vertex, c3_Edge_Weight);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("Graph");
//		System.out.println("Betweenness calculation ");
//		r.BetweenNess_Centrality_Score(Distinct_Vertex, Source_Vertex, Target_Vertex, Edge_Weight);
	}
}
