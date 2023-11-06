package lotto.model;

import java.util.List;

public class BonusNumber {
	
	private final String IS_NUMBER_RANGE_1_TO_45_MESSAGE = "보너스 번호의 범위는 1~45 사이의 값이여야 합니다.";
	private final String IS_DUPLICATION_MESSAGE = "보너스 번호는 당첨 번호와 중복되어서는 안됩니다.";
	
	private final String ERROR_MESSAGE_TAG = "[ERROR] ";
	private final int MIN_LOTTO_NUMBER = 1;
	private final int MAX_LOTTO_NUMBER = 45;
	
	private final int number;
	
	public BonusNumber(int bonusNumber, Lotto lotto){
		validate(bonusNumber, lotto);
		this.number = bonusNumber;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	private void validate(int bonusNumber, Lotto lotto) {
		if(!isNumbersRange1to45(bonusNumber))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG+IS_NUMBER_RANGE_1_TO_45_MESSAGE);
		if(isDuplicationNumber(bonusNumber, lotto.getNumbers()))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG+IS_DUPLICATION_MESSAGE);
	}
	
	private boolean isNumbersRange1to45(int bonusNumber) {
		return (bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER);
	}

	private boolean isDuplicationNumber(int bonusNumber, List<Integer> lottoNumber) {
		return lottoNumber.contains(bonusNumber);
	}
}
