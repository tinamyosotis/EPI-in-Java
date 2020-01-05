import java.util.ArrayList;
import java.util.List;

public class Solution18 {
    //    the question is to try to find a way from start to end in a maze
    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            if (this.x != that.x || this.y != that.y) {
                return false;
            }
            return true;
        }
    }

    public enum Color {WHITE, BLACK}

    public static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        searchMazeHelper(maze, start, end, path);
        return path;
    }

    public static boolean searchMazeHelper(List<List<Color>> maze, Coordinate curr, Coordinate end, List<Coordinate> path) {
        if (curr.x < 0 || curr.x >= maze.size() || curr.y < 0 || curr.y >= maze.get(curr.x).size() || maze.get(curr.x).get(curr.y) != Color.WHITE) {
            return false;
        }
        path.add(curr);
        maze.get(curr.x).set(curr.y, Color.BLACK);
        if (curr.equals(end)) {
            return true;
        }
        //        try to find a way from four different directions
        for (int[] dir : dirs) {
            Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
            if (searchMazeHelper(maze, next, end, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}
