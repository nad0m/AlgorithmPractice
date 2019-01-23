import java.util.*;

public class RiverSizes {
    public static ArrayList<Integer> riverSizes(int[][] matrix)
    {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == 1 && !visited[i][j])
                {
                    visited[i][j] = true;
                    Queue<Integer[]> queue = new LinkedList<>();
                    queue.add(new Integer[]{i,j});
                    Integer riverSize = 1;

                    while (!queue.isEmpty())
                    {
                        Integer[] node = queue.poll();
                        ArrayList<Integer[]> neighbors = getNeighborsFor(node[0], node[1], matrix);

                        for (Integer[] n : neighbors)
                        {
                            if (!visited[n[0]][n[1]] && matrix[n[0]][n[1]] == 1)
                            {
                                visited[n[0]][n[1]] = true;
                                riverSize++;
                                queue.add(new Integer[]{n[0],n[1]});
                            }
                        }

                    }

                    result.add(riverSize);
                }
            }
        }

        return result;
    }

    public static ArrayList<Integer[]> getNeighborsFor(int i, int j, int[][] matrix)
    {
        ArrayList<Integer[]> neighbors = new ArrayList<>();

        //check top neighbor
        if (i - 1 >= 0)
            neighbors.add(new Integer[]{i-1, j});

        //check left neighbor
        if (j - 1 >= 0)
            neighbors.add(new Integer[]{i, j-1});

        //check bottom neighbor
        if (i + 1 < matrix.length)
            neighbors.add(new Integer[]{i+1, j});

        //check right neighbor
        if (j + 1 < matrix[0].length)
            neighbors.add(new Integer[]{i, j+1});

        return neighbors;
    }



    public static void main(String[] args)
    {
        int[][] matrix = {  {1, 0, 0, 1, 1},
                            {1, 0, 0, 1, 1},
                            {1, 0, 0, 1, 1},
                            {1, 0, 0, 1, 1},
                            {1, 0, 0, 1, 1},  };

        System.out.println(riverSizes(matrix));
    }


}

