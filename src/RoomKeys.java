/**
 * Created by Huy Nguyen on 01/23/2019.
 */

import java.util.*;

public class RoomKeys
{
    /**
     * BFS iterative approach
     * @param rooms
     * @return
     */
    public static boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {

        boolean[] visitHash = new boolean[rooms.size()];
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(rooms.get(0)); // visit first room at index 0
        visitHash[0] = true; // mark as visited

        while (!queue.isEmpty())
        {
            List<Integer> room = queue.poll(); // grab key(s)

            for (int key : room)
            {
                // if we have not visited the room, use key to enter
                if (!visitHash[key])
                {
                    queue.add(rooms.get(key)); // visit room at index key
                    visitHash[key] = true; // mark as visited
                }
            }
        }

        return allRoomsVisited(visitHash);
    }

    /**
     * DFS iterative approach
     * @param rooms
     * @return
     */
    public static boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {

        boolean[] visitHash = new boolean[rooms.size()];
        Stack<List<Integer>> stack = new Stack<>();

        stack.add(rooms.get(0)); // visit first room at index 0
        visitHash[0] = true; // mark as visited

        while (!stack.isEmpty())
        {
            List<Integer> room = stack.pop(); // grab key(s)

            for (int key : room)
            {
                // if we have not visited the room, use key to enter
                if (!visitHash[key])
                {
                    stack.add(rooms.get(key)); // visit room at index key
                    visitHash[key] = true; // mark as visited
                }
            }
        }

        return allRoomsVisited(visitHash);

    }

    /**
     * Check if all rooms visited
     * @param visitHash
     * @return
     */
    public static boolean allRoomsVisited(boolean[] visitHash)
    {
        for (boolean visited : visitHash)
        {
            if (!visited)
                return false;
        }

        return true;
    }

    /**
     * Driver
     * @param args
     */
    public static void main(String[] args)
    {

        Integer[][] rooms = {
                            {6,7,8},
                            {5,4,9},
                            {},
                            {8},
                            {4},
                            {},
                            {1,9,2,3},
                            {7},
                            {6,5},
                            {2,3,1}
                                    };


        System.out.println("BFS: " + canVisitAllRoomsBFS(twoDArrayToList(rooms)));
        System.out.println("DFS: " + canVisitAllRoomsDFS(twoDArrayToList(rooms)));
    }


    /**
     * Helper: convery primitive 2D arrays into 2D lists
     * @param twoDArray
     * @return
     */
    public static List<List<Integer>> twoDArrayToList(Integer[][] twoDArray) {
        List list = new ArrayList();
        for (Integer[] array : twoDArray) {
            list.add(Arrays.asList(array));
        }

        return list;
    }

}
