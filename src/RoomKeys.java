import java.util.*;

public class RoomKeys
{
    public static boolean canVisitAllRooms(int[][] rooms)
    {
        boolean[] visitHash = new boolean[rooms.length];
        visitHash[0] = true;

        for (int i = 0; i < rooms.length; i++)
        {
            // if we have key for room i, enter room and grab key(s)
            if (visitHash[i])
            {
                for (int key : rooms[i])
                {
                    visitHash[key] = true;
                }
            }
        }

        return allRoomsVisited(visitHash);
    }

    public static boolean allRoomsVisited(boolean[] visitHash)
    {
        for (boolean visited : visitHash)
        {
            if (!visited)
                return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[][] room = {    {1, 3},
                            {3, 0, 1},
                            {2},
                            {0},
                                 };

        int[][] room2 = {   {1},
                            {2},
                            {3},
                            {},
                                };

        System.out.println("Room: " + canVisitAllRooms(room));
        System.out.println("Room2: " + canVisitAllRooms(room2));
    }

}
