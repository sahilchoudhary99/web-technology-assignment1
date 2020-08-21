/* java program to find shortest path between two nodes */

import java.util.*;
public class Spath
{   
    public static boolean findpath(int edges[][],int v,int s,int e,boolean[] visited)
	{
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
        q.add(s);
        visited[s]=true;
		boolean check=false;
        while(!q.isEmpty())
		{
			int curr=q.remove();
			if(curr==e)
			{  check=true; break;  }
		    for(int i=0;i<v;i++)
			{
				if(edges[curr][i]==1 && !visited[i])
				{
					q.add(i);
					visited[i]=true;
					m.put(i,curr);
				}
			}
		} 
		int vertex=e;
		Stack<Integer> stk=new Stack<Integer>();
		while(check)
		{
			if(vertex==e)
				stk.push(vertex);
			if(m.containsKey(vertex))
			{   stk.push(m.get(vertex));
			    vertex=m.get(vertex);   }
			else
				break;
		}
		if(check)
		    System.out.print("Shortest path is: ");
		while(!stk.empty())
		{  System.out.print(stk.pop());
		    if(stk.size() > 0)
				System.out.print("->");
		}
		return check;
	}
    public static void main(String[] args)
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
            System.out.println("Enter the number of vertices");
            number_of_vertices = scan.nextInt();
            adjacency_matrix = new int[number_of_vertices][number_of_vertices];
 
            System.out.println("Enter the total number of edges:");
			int edges = scan.nextInt();
            for (int i = 0; i < number_of_vertices; i++)
            {
                for (int j = 0; j < number_of_vertices; j++)
                {
                    adjacency_matrix[i][j]=0;
                }
            }
            System.out.println("Enter the edges seperated by space: ");
			for(int i=0;i<edges;i++)
			{
				int sv,ev;
				sv=scan.nextInt();ev=scan.nextInt();
				adjacency_matrix[sv][ev]=1;
				adjacency_matrix[ev][sv]=1;
			}
			boolean[] visited=new boolean[number_of_vertices];
			for(int i=0;i<number_of_vertices;i++)
				visited[i]=false;
            System.out.println("Enter the source vertex:");
            source = scan.nextInt();
            System.out.println("Enter the destination vertex:");
            destination = scan.nextInt();
            boolean ans=findpath(adjacency_matrix,number_of_vertices,source,destination,visited);
			if(!ans)
				System.out.println("Negative cycles exist");
    }
}
//YES, program can be extended to find all possible paths bewteen two nodes