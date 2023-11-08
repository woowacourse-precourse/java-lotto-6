package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ErrorCode;

public class LottoSeller {
	private static final int LOTTO_PRICE = 1000;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_COUNT = 6;

	public List<Lotto> sellLotto(final int amount) {
		final var totalQuantity = amount / LOTTO_PRICE;
		final var lottos = new ArrayList<Lotto>();
		for (int i = 0; i < totalQuantity; i++) {
			final var lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
			final var lotto = new Lotto(lottoNumbers);
			lottos.add(lotto);
		}
		return lottos;
	}

	public static List<Integer> validateWinningNumbers(final String[] split) {
		if (split.length != 6) {
			throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_LENGTH.message());
		}

		final var numbers = new ArrayList<Integer>();
		for (var input : split) {
			final var number = parseToInteger(input);
			checkRange(number);
			numbers.add(number);
		}
		final var uniqueNumbers = new HashSet<>(numbers);
		checkSize(uniqueNumbers);
		return new ArrayList<>(uniqueNumbers);
	}

	public static int validatePurchaseAmount(String value) {
		int amount;
		while (true) {
			try {
				amount = Integer.parseInt(value);
				if ((amount % 1000) != 0) {
					throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.message());
				}
				return amount;
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_VALUE.message());
			}
		}
	}
	public static int parseToInteger(final String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_VALUE.message());
		}
	}

	public static void checkRange(final int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_RANGE.message());
		}
	}

	public static void checkSize(final Set<?> numbers) {
		if (numbers.size() != LOTTO_COUNT) {
			throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_LENGTH.message());
		}
	}
}
