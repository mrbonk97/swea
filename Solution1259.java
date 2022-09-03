import java.util.*;
import java.io.*;


class Solution1259
{
    static int [][] bolt;
    static boolean [] vis;
    static int size;
    static int depth = 0;

    static int [] ans;
    static int index = 0;

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input1259.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.printf("#%d ",test_case);
            size = Integer.parseInt(br.readLine());
            bolt = new int[size][2];
            vis = new boolean [size];
            ans = new int[size*2];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < size; i++)
            {
                bolt[i][0] = Integer.parseInt(st.nextToken());
                bolt[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < size; i++)
            {
                depth = 1;
                vis[i] = true;
                ans[index++] = bolt[i][0];
                ans[index++] = bolt[i][1];
                dfs(bolt[i][1]);
                vis[i] = false;
                index-= 2;
            }
		}
	}

    public static void dfs(int start) {
        if(depth == size)
        {
            for(int i = 0; i < size*2; i++) System.out.printf("%d ", ans[i]);
            System.out.println();
            return;
        }

        for(int i = 0; i < size; i++)
        {
            if(vis[i] == false && bolt[i][0] == start)
            {
                depth++;
                vis[i] = true;
                ans[index++] = bolt[i][0];
                ans[index++] = bolt[i][1];
                dfs(bolt[i][1]);
                vis[i] = false;
                depth--;
                index-=2;
            }
        }
    }
}