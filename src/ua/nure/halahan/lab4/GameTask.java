package ua.nure.halahan.lab4;

import java.util.Random;

public class GameTask {

    private Player player1 = null;
    private Player player2 = null;
    private int[][] map;
    private Tree<int[][]> tree;
    private String gameResult = "";

    public int[][] getMap() {
        return this.map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public Tree<int[][]> getTree() {
        return this.tree;
    }

    public void setTree(Tree<int[][]> tree) {
        this.tree = tree;
    }

    public String getGameResult() {
        return this.gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }


    public GameTask() {
        player1 = new Player();
        player2 = new Player();
        player2.setIsMin(true);
        player1.setIsMin(false);

        this.initMap();
        this.initTree();
        player1.setCurrentNode(tree);

        boolean run = true;
        boolean playerFirstStep = true;
        while (run) {
            if (playerFirstStep) {
                player1.performStep();
                this.map = player1.getCurrentNode().getValue();
                this.tree = player1.getCurrentNode();
                player2.setCurrentNode(tree);
                playerFirstStep = false;
            } else {
                player2.performStep();
                this.map = player2.getCurrentNode().getValue();
                this.tree = player2.getCurrentNode();
                player1.setCurrentNode(tree);
                playerFirstStep = true;
            }

            run = !(checkIsGameOver() || hasWin(true));
        }
    }

    private void initMap() {
        int n = 3;
        this.map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; ) {
                this.map[i][j] = 0;
            }
        }
    }

    public boolean hasWin(boolean player1) {
        int value = 2;

        if (map != null) {

            /*
             x - -
			 - x -
			 - - x
			 */
            if (this.map[0][0] == value && this.map[1][1] == value && this.map[2][2] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }
			/*
			 - - x
			 - x -
			 x - -
			 */
            if (this.map[0][2] == value && this.map[1][1] == value && this.map[2][0] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }

			/*
			 x x x
			 - - -
			 - - -
			 */
            if (this.map[0][0] == value && this.map[0][1] == value && this.map[0][2] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }
			
			/*
			 - - -
			 x x x
			 - - -
			 */
            if (this.map[1][0] == value && this.map[1][1] == value && this.map[1][2] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }
			
			/*
			 - - -
			 - - -
			 x x x
			 */
            if (this.map[2][0] == value && this.map[2][1] == value && this.map[2][2] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }
			
			/*
			 x - -
			 x - -
			 x - -
			 */
            if (this.map[0][0] == value && this.map[1][0] == value && this.map[2][0] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }

			/*
			 - x -
			 - x -
			 - x -
			 */
            if (this.map[0][1] == value && this.map[1][1] == value && this.map[2][1] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }
			/*
			- - x
			- - x
			- - x
			*/
            if (this.map[0][2] == value && this.map[1][2] == value && this.map[2][2] == value) {
                if (player1)
                    this.setGameResult("Player1 Win");
                else
                    this.setGameResult("Player2 Win");
                return true;
            }
        }
        return false;
    }

    public boolean checkIsGameOver() {
        if (map != null) {
            for (int[] i : this.map) {
                for (int j : i) {
                    if (j == 0) {
                        return false;
                    }
                }
            }
        }
        this.setGameResult("Dead Heat");
        return true;
    }


    private void initTree() {
        this.tree = new Tree<int[][]>();
        this.tree.setValue(map);
        generateChild(tree, 1);
    }

    private int[][] copy(int[][] map) {
        int[][] result = new int[3][3];
        int n = 0, k = 0;
        for (int[] i : map) {
            n = 0;
            for (int j : i) {
                result[k][n] = map[k][n];
                n++;
            }
            k++;
        }
        return result;
    }

    public void generateChild(Tree<int[][]> node, int value) {
        Random rand = new Random();
        int k = 0, n = 0;
        int val = value;
        for (int[] i : node.getValue()) {
            n = 0;
            for (int j : i) {
                if (j == 0) {
                    int[][] map = copy(node.getValue());
                    map[k][n] = value;
                    int cost = rand.nextInt(100);

                    Tree<int[][]> child = new Tree<int[][]>(node, 0, cost, map);
                    node.addChildren(child);
                    if (value == 1) {
                        val = 2;
                    } else {
                        val = 1;
                    }
                    generateChild(child, val);
                }
                n++;
            }
            k++;
        }
    }
}
