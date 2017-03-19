package ua.nure.halahan.lab4;

import java.util.LinkedList;


public class Tree<T> {

    private int deep;
    private int cost;
    private T value;
    private LinkedList<Tree<T>> children;
    private Tree<T> parent = null;

	public Tree() {
		this.children = new LinkedList<>();
		this.setCost(0);
	}

	public Tree(Tree<T> parent, int deep, int cost, T value) {
		this.setParent(parent);
		this.setDeep(deep);
		this.setCost(cost);
		this.setValue(value);
		this.children = new LinkedList<>();
	}

	public Tree<T> getParent() { return this.parent; }

	public void setParent(Tree<T> parent) { this.parent = parent; }

	public LinkedList<Tree<T>> getChildren() { return this.children; }

	public void setChildren(LinkedList<Tree<T>> children) {this.children = children;}

	public void addChildren(Tree<T> children) {
		this.children.add(children);
	}

	public void removeChildren(Tree<T> children) {
		this.children.remove(children);
	}

	public int getDeep() {return this.deep;}

	public void setDeep(int deep) {this.deep = deep;}

	public int getCost() {return this.cost;}

	public void setCost(int cost) {this.cost = cost;}

	public T getValue() {return this.value;}

	public void setValue(T value) {this.value = value;}
}
