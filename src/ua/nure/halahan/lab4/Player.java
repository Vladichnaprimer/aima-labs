package ua.nure.halahan.lab4;

import java.util.LinkedList;

public class Player {

	private int alpha = Integer.MIN_VALUE;
	private int beta = Integer.MAX_VALUE;
	private boolean isMin;
	private Tree<int[][]> currentNode;

	public Player() {
		this.setIsMin(true);
	}

	public boolean getIsMin() {return this.isMin;}

	void setIsMin(boolean isMin) {this.isMin = isMin;}

	Tree<int[][]> getCurrentNode() {return this.currentNode;}

	void setCurrentNode(Tree<int[][]> node) {this.currentNode = node;}

	void performStep() {
		this.miniMax(false);
	}

	private void miniMax(boolean alphaBeta) {
		Tree<int[][]> best = new Tree<int[][]>();

		if(alphaBeta) {
			LinkedList<Tree<int[][]>> listToDelete = new LinkedList<>();
			
			if(isMin) {
				this.findBeta();
				
				for(Tree<int[][]> child : this.currentNode.getChildren()) {
					if(currentNode.getCost() + child.getCost() > beta) {
						listToDelete.add(child);
					}
				}
			} else {
				this.findAlpha();
				for(Tree<int[][]> child : this.currentNode.getChildren()) {
					if(currentNode.getCost() + child.getCost() > alpha) {
						listToDelete.add(child);
					}
				}
			}
			
			for(Tree<int[][]> child : listToDelete) {
				currentNode.removeChildren(child);
			}
		}

		if(isMin) {
			best.setCost(Integer.MAX_VALUE);
		} else {
			best.setCost(Integer.MIN_VALUE);
		}
		for(Tree<int[][]> child : this.currentNode.getChildren()) {
			if(isMin) {
				if(child.getCost() < best.getCost()) {
					best = child;
				}
			} else {
				if(child.getCost() > best.getCost()) {
					best = child;
				}
			}
		}
		this.currentNode = best;
	}

	void findAlpha() {
		for(Tree<int[][]> child : this.currentNode.getChildren()) {
			if(this.currentNode.getCost() + child.getCost() > alpha) {
				this.alpha = this.currentNode.getCost() + child.getCost();
			}
		}
	}

	void findBeta() {
		for(Tree<int[][]> child : this.currentNode.getChildren()) {
			if(this.currentNode.getCost() + child.getCost() < beta) {
				this.beta = this.currentNode.getCost() + child.getCost();
			}
		}
	}
}
