import java.util.LinkedList;
import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.Arrays;

public class TrainPaths {
	int totalCost=0,routeno=0;
	String finalstr;
	String[] q = new String[10];
	Stack<Integer> stk = new Stack<Integer>();
	
    public void print(Graph graph, int start, int end, String path, boolean[] visited){
        String newPath = path+">"+start;
        visited[start] = true;
        LinkedList<Node> list = graph.adjacencyList[start];
        for (int i = 0; i <list.size() ; i++) {
            Node node = list.get(i);
            totalCost+=node.cost;
            if(node.destination!=end && visited[node.destination]==false){
                print(graph,node.destination,end,newPath,visited);
            }else if(node.destination==end){
                finalstr=newPath+">"+node.destination+">"+totalCost;
                q[routeno]=finalstr;
                stk.push(totalCost);
                routeno+=1;
            }
        }
        visited[start] = false;
    }

    public void printAllPaths(Graph graph, int start, int end){
        boolean[] visited = new boolean[graph.vertices];
        visited[start] = true;
        print(graph, start, end, "", visited);
    }
    
   public void Solution(Map<String,String> map)
    {
    	int i=0,j,k;
    	int[] cost = new int[stk.size()];
    	String route;
    	int arrsize;
    	int c;
    	String[] states;
    	
    	if(stk.empty())
    	{
    		System.out.println("Not reachable");
    		return;
    	}
    	
    	while(!stk.empty())
    	{
    		cost[i]=stk.pop();
    		i++;
    	}
    	
    	Arrays.sort(cost);
    	
    	for(i=0;i<cost.length;i++)
    	{
    		for(j=0;j<routeno;j++)
    		{
    			route = q[j];
    			states = route.split(">");
    			arrsize = states.length;
    			c = Integer.parseInt(states[arrsize-1]);
    			if(cost[i]==c)
    			{
    				for(k=1;k<arrsize-1;k++)
    				{
    					System.out.print(map.get(states[k])+" ");
    				}
    				System.out.println(c);
    			}
    		}
    	}
    	
    }

    public static void main(String[] args) {
    	
		Map<String, Integer> map1 = new HashMap<String,Integer>();
    	map1.put("Delhi",0);
    	map1.put("Pune",1);
    	map1.put("Nagpur",2);
    	map1.put("Hyderabad",3);
    	map1.put("Vizag",4);
    	map1.put("Chennai",5);
    	
    	int vertices = 6;
        Graph graph = new Graph(vertices);
        int n,s,d,c;
        String src,dest;
    	
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        
        for(int i=0;i<n;i++)
        {
        	src = scan.next();
        	dest = scan.next();
        	c = scan.nextInt();
        	s = map1.get(src);
        	d = map1.get(dest);
        	graph.addEdge(s,d,c);
        }

        TrainPaths p = new TrainPaths();
        p.printAllPaths(graph,0,5);
        Map<String, String> map = new HashMap<String,String>();
    	map.put("0","Delhi");
    	map.put("1","Pune");
    	map.put("2","Nagpur");
    	map.put("3","Hyderabad");
    	map.put("4","Vizag");
    	map.put("5","Chennai");
        p.Solution(map);
    }
}

class Graph{
    int vertices;
    LinkedList<Node> [] adjacencyList;

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i <vertices; i++) {
            adjacencyList[i] = new LinkedList<Node>();
        }
    }

    public void addEdge(int source, int destination,int cost){
        Node node = new Node(source, destination, cost);
        adjacencyList[source].addLast(node);
    }
}

class Node{
    int source;
    int destination;
    int cost;

    public Node(int source, int destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost=cost;
    }
}
