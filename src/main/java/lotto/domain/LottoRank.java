package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.BiPredicate;

public enum LottoRank {

	NOTHING(0, 0, false, (matchedNumCount, isBonusNumber) -> matchedNumCount < 3),
	FIFTH(5000, 3, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 3),
	FOURTH(50000, 4, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 4),
	THIRD(1500000, 5, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 5 && isBonusNumber == false),
	SECOND(30000000, 5, true, (matchedNumCount, isBonusNumber) -> matchedNumCount == 5 && isBonusNumber == true),
	FIRST(2000000000, 6, false, (matchedNumCount, isBonusNumber) -> matchedNumCount == 6);

	private final int price;
	private final int matchedNumCount;
	private final boolean isBonusNumber;
	private final BiPredicate<Integer, Boolean> matchingCondition;

	LottoRank(int price, int matchedNumCount, boolean isBonusNumber, BiPredicate<Integer, Boolean> winningCondition) {
		this.price = price;
		this.matchedNumCount = matchedNumCount;
		this.isBonusNumber = isBonusNumber;
		this.matchingCondition = winningCondition;
	}

	public static LottoRank getMatchedLottoRank(AnswerLotto answerLotto, Lotto lotto) {
		int matchedNumberCount = countMatchedNumber(answerLotto, lotto);

		boolean isBonusNumber = isNumberSameAsBonusNumber(answerLotto, lotto);

		return LottoRank.getMatchedLottoRank(matchedNumberCount, isBonusNumber);
	}

	private static LottoRank getMatchedLottoRank(int matchedNumberCount, boolean isBonusNumber) {
		return Arrays.stream(LottoRank.values())
				.filter(lottoRank -> lottoRank.matchingCondition.test(matchedNumberCount, isBonusNumber))
				.findAny()
				.orElse(NOTHING);
	}

	private static int countMatchedNumber(AnswerLotto answerLotto, Lotto lotto) {
		int matchedNumberCount = 0;

		for (int index = 0; index < lotto.getSize(); index++) {
			if (answerLotto.isContain(lotto.getNumber(index))) {
				matchedNumberCount++;
			}
		}

		return matchedNumberCount;
	}

	private static boolean isNumberSameAsBonusNumber(AnswerLotto answerLotto, Lotto lotto) {
		boolean isBonusNumber = false;

		for (int index = 0; index < lotto.getSize(); index++) {
			if (answerLotto.getBonusNumber() == lotto.getNumber(index)) {
				isBonusNumber = true;
				break;
			}
		}

		return isBonusNumber;
	}

	public static EnumMap<LottoRank, Integer> initializeLottoRankCounter() {
		EnumMap<LottoRank, Integer> lottRankCounter = new EnumMap<>(LottoRank.class);
		Arrays.stream(LottoRank.values()).forEach(lottoRank -> lottRankCounter.put(lottoRank, 0));
		return lottRankCounter;
	}

	public int getPrice() {
		return price;
	}

	public int getMatchedNumCount() {
		return matchedNumCount;
	}

	public boolean getisBonusNumber() {
		return isBonusNumber;
	}
}
