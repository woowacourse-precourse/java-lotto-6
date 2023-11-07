package lotto.Utils;

public enum Units{
	Lotto_Price_Unit(1000,","),
	Lotto_Min_Number(1,","),
	Lotto_Max_Number(45,","),
	Lotto_Length(6,","),
	;
	
	private final int Unit;
	private final String Delimiter;
	
	Units(Integer Unit, String Delimiter) {
		this.Unit = Unit;
		this.Delimiter = Delimiter;
	}
	
	public int Unit() {
		return Unit;
	}
	public String Delimiter() {
		return Delimiter;
	}
	
}