package lotto.domain;

public class LottoGenerator {
	
	static final int price = 1000;
	private final int paid;
	
	public LottoGenerator(int paid) {
		amountValidate(paid);
		UnitValidate(paid);
		this.paid = paid;
	}

	
	private void amountValidate(int paid) {
		if ( paid < price ) {
			throw new IllegalArgumentException();
		}
	}
	
	private void UnitValidate(int paid) {
		if ( paid % price != 0) {
			throw new IllegalArgumentException();
		}
	}
}
