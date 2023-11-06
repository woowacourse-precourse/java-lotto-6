package lotto.domain;

import java.util.Objects;

public class LottoNumber {

	public static final int MAX_NUMBER = 45;
	public static final int MIN_NUMBER = 1;
	public static final String WRONG_RANGE_NUMBER_MESSAGE = "잘못된 로또 번호입니다.";
	private final int number;

	private LottoNumber(int number) {
		validate(number);
		this.number = number;
	}

	public static LottoNumber from(int number) {
		return new LottoNumber(number);
	}

	private void validate(int number) {
		if (isLottoNumberRange(number)) {
			throw new IllegalArgumentException(WRONG_RANGE_NUMBER_MESSAGE);
		}
	}

	private boolean isLottoNumberRange(int number) {
		return number < MIN_NUMBER || number > MAX_NUMBER;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
