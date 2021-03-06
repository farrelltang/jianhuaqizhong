package edu.olivet.se530.ioc;

class AbstractPig {
	public AbstractPig() {}
	
	AbstractPig(int weight) {
		this.weight = weight;
	}
	
	private int weight;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("我是一头%s斤重的猪", weight);
	}
	
	public void init() {
		System.out.println("我是猪...一头初始化了的猪...");
	}
}