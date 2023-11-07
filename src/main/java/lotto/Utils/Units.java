package lotto.Utils;

public enum Units{
	Lotto_Price_Unit(1000),
	Lotto_Min_Number(1),
	Lotto_Max_Number(45),
	Lotto_Length(6),
	;
	
	private final int Unit;

	Units(Integer Unit) {
		this.Unit = Unit;
	}
	
	public int Unit() {
		return Unit;
	}
	
}