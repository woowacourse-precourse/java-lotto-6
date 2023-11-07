package model;

public enum Constants {
	
	UNIT_PRICE(1000),
	
	INIT_CNT(0),
	
	MIN_NUM(1),
	MAX_NUM(45),
	CORRECT_CNT(6);
	
	private final int val;

	Constants(int val) {
		this.val=val;
	}
	
	public int getConstants() {
		return val;
	}
}
