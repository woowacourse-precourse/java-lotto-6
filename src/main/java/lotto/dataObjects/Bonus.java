package lotto.dataObjects;

public class Bonus {

	private int number;

	public Bonus(int number, Lotto lotto) {
		validateDuplicate(number, lotto);
		this.number = number;
	}

	private void validateDuplicate(int number, Lotto lotto) {
		lotto.validateDuplicateWithBonus(number);
	}

	public int getNumber() {
		return number;
	}

}
