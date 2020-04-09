package mazeResolver;

import java.util.LinkedList;

public class MazeResolver {
	
	static int[][] maze = {
			{2, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
			{1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
			{0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
	};
	//0 = wall
	//1 = path
	//2 = destination
	
	static LinkedList<Position> path = new LinkedList<Position>();
	
	public static void main(String[] args) {
		Position p = new Position(4, 8);
		path.push(p);
		
		
		
		
		
		while(true) {
			int y = path.peek().y;
			int x = path.peek().x;
			
			maze [y][x] = 0;
			
			if(isValid(y+1, x)) {
				//down			
				if(maze[y+1][x] == 2) {
					System.out.println("Moved down. You won!");
					return;
				}else if(maze[y+1][x] == 1) {
					System.out.println("Move down");
					path.push(new Position(y+1, x));
					continue;
				}
				
			}
			
			if(isValid(y, x-1)) {
				//left			
				if(maze[y][x-1] == 2) {
					System.out.println("Moved left. You won!");
					return;
				}else if(maze[y][x-1] == 1) {
					System.out.println("Move left");
					path.push(new Position(y, x-1));
					continue;
				}
				
			}
			
			if(isValid(y-1, x)) {
				//up			
				if(maze[y-1][x] == 2) {
					System.out.println("Moved up. You won!");
					return;
				}else if(maze[y-1][x] == 1) {
					System.out.println("Move up");
					path.push(new Position(y-1, x));
					continue;
				}
			}
			
			if(isValid(y, x+1)) {
				//right			
				if(maze[y][x+1] == 2) {
					System.out.println("Moved right. You won!");
					return;
				}else if(maze[y][x+1] == 1) {
					System.out.println("Move right");
					path.push(new Position(y, x+1));
					continue;
				}
			}
			
			
			path.pop();
			System.out.println("Move back.");
			if(path.size() <= 0) {
				System.out.println("No path");
				return;
			}	
		//maze[path.peek().y][path.peek().x] = 0;
		}
		
	}
	
	public static boolean isValid(int y, int x) {
		if(y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
			return false;
		}
		return true;
	}

}
