package lotto.domain;

import static lotto.domain.Customer.*;
import static lotto.domain.Lotto.*;
import static lotto.provider.LottoInputProvider.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.ErrorType;

public class LottoMachine {

	public static final int MIN_LOTTO_PRICE = 1000;

	private Lotto winningNumbers;
	private int bonusNumber;

	public Lotto getWinningNumbers() {
		return winningNumbers;
	}

	public void setWinningNumbers(Lotto winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(int bonusNumber) {
		validateBonusNumber(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public List<Lotto> sellLotto(int price) {
		validatePrice(price);

		int lottoAmount = price / MIN_LOTTO_PRICE;

		return IntStream.range(0, lottoAmount)
			.mapToObj(i -> generateRandomLotto())
			.collect(Collectors.toList());
	}

	private Lotto generateRandomLotto() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(
			MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.MAX_LOTTO_SIZE));
	}

	private void validateBonusNumber(int bonusNumber) {
		if (winningNumbers.getNumbers().contains(bonusNumber) || !isInRange(bonusNumber))
			throw new IllegalArgumentException(ErrorType.INVALID_BONUS_NUMBER.getErrorMessage());
	}

	private boolean isInRange(int bonusNumber) {
		return bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER;
	}

	private void validatePrice(int price) {
		if (price < MIN_LOTTO_PRICE || price % MIN_LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_ERROR.getErrorMessage());
		}
	}

}
