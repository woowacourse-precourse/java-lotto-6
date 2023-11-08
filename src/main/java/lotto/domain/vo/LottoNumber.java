package lotto.domain.vo;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.constant.LottoValue;
import lotto.validation.Validator;
import lotto.validation.validators.InvalidLottoNumber;
import lotto.validation.validators.LottoGameValidator;

public class LottoNumber extends LottoValue {

	private static final int INDEX_GAP = 1;
	private static final List<LottoNumber> CACHE_NUMBER;

	static {
		CACHE_NUMBER =
				IntStream.rangeClosed(MINIMUM_INCLUSIVE_NUMBER, MAXIMUM_INCLUSIVE_NUMBER)
						.mapToObj(LottoNumber::new)
						.toList();
	}

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber valueOf(int number) {
		Validator.of(new LottoGameValidator[]{
				new InvalidLottoNumber()
		}).validate(number);
		return CACHE_NUMBER.get(number - INDEX_GAP);
	}

	public int getNumber() {
		return this.number;
	}
}