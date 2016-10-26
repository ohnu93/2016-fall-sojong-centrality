package centrality;

public class Position {
	String h1, h2;
	int cluster, position, count;
	
	public Position(String h1, String h2, int cluster, int position) {
		this.h1 = h1;
		this.h2 = h2;
		this.cluster = cluster;
		this.position = position;
		this.count = 0;
	}
	
	public boolean isEqual(Position p) {
		return (h1.equalsIgnoreCase(p.h1) && h2.equalsIgnoreCase(p.h2) && cluster==p.cluster);
	}
	
	public void incrCount() { ++count; }
	
	public int getCount() { return count; }
	public int getCluster() { return cluster; }
	public int getPosition() { return position; }
}
