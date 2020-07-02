package model;

public class Node {
	Node parent;
	Node rLeaf;
	Node lLeaf;
	
	public Node(Node parent) {
		this.parent = parent;
	}
	
	public Node(Node parent, Node lLeaf) {
		this.parent = parent;
		
	}
	
	public Node(Node parent, Node rLeaf) {
		
	}
	
	public Node(Node parent, Node lLeaf, Node rLeaf) {
		
	}
}
