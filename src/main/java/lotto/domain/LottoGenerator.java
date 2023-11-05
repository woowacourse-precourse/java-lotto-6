package lotto.domain;

public class LottoGenerator {
	
	static final int price = 1000;
	private final int paid;
	
	public LottoGenerator(int paid) {
		amountValidate(paid);
		this.paid = paid;
	}
	
	private void amountValidate(int paid) {
		if ( paid < price ) {
			throw new IllegalArgumentException();
		}
	}
	
	
}
