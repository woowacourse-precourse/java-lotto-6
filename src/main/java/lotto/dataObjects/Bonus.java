package lotto.dataObjects;

public class Bonus {

	private int number;

	public Bonus(int number, Lotto lotto) {
		validateDuplicate(lotto);
		this.number = number;
	}

	private void validateDuplicate(Lotto lotto) {
		lotto.validateDuplicateWithBonus(this.number);
	}

	public int getNumber() {
		return number;
	}

}
