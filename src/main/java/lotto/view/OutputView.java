package lotto.view;

import lotto.domain.Cash;
import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.LottoResult;
import java.text.DecimalFormat;

import static lotto.util.CharacterUnits.ENTER;
import static lotto.util.PatternUnits.PATTERN_FOR_DECIMAL_FORMAT;
import static lotto.view.OutputViewMessage.PURCHASED_LOTTOS_MESSAGE_FORMAT;
import static lotto.view.OutputViewMessage.WINNING_STATIC_MESSAGE;
import static lotto.view.OutputViewMessage.SECOND_PLACE_RESULT_MESSAGE_FORMAT;
import static lotto.view.OutputViewMessage.OTHER_PLACE_RESULT_MESSAGE_FORMAT;
import static lotto.view.OutputViewMessage.TOTAL_BENEFIT_MESSAGE_FORMAT;

public class OutputView {

	private static final Integer INIT_BUILDER_SIZE = 0;
	private static final DecimalFormat formatter = new DecimalFormat(
		PATTERN_FOR_DECIMAL_FORMAT.getPattern());
	;
	private static final StringBuilder outputBuilder = new StringBuilder();


	public static void printPurchasedLottos(final Lottos lottos) {
		initOutputBuilder();
		generatePurchasedLottosOutputBuilder(lottos);
		printOutputBuilder();

	}

	private static void generatePurchasedLottosOutputBuilder(final Lottos lottos) {
		outputBuilder.append(ENTER.getUnit())
			.append(String.format(PURCHASED_LOTTOS_MESSAGE_FORMAT.getMessage(), lottos.getCount()))
			.append(ENTER.getUnit());

		for (final Lotto lotto : lottos.getLottos()) {
			outputBuilder.append(lotto.toString())
				.append(ENTER.getUnit());
		}
	}


	public static void printStaticResult(final LottoResult lottoResult, final Cash cash) {
		initOutputBuilder();
		generateStaticResultOutputBuilder(lottoResult);
		generateTotalBenefitOutputBuilder(lottoResult, cash);
		printOutputBuilder();
	}

	private static void generateStaticResultOutputBuilder(final LottoResult lottoResult) {
		outputBuilder.append(WINNING_STATIC_MESSAGE.getMessage());
		for (final Prize prize : Prize.values()) {
			generateRankingResultOutputBuilder(prize,
				lottoResult.countPrize(prize));
			outputBuilder.append(ENTER.getUnit());
		}
	}

	private static void generateRankingResultOutputBuilder(final Prize prize,
		final Integer countOfPrize) {
		if (prize.isBonusNumber()) {
			generateSecondPlaceResultOutputBuilder(prize, countOfPrize);
		} else if (!prize.isBonusNumber() && prize != Prize.LAST_PLACE) {
			generateOtherPlaceResultOutputBuilder(prize, countOfPrize);
		}

	}

	private static void generateSecondPlaceResultOutputBuilder(final Prize prize,
		final Integer countOfPrize) {
		outputBuilder.append(String.format(SECOND_PLACE_RESULT_MESSAGE_FORMAT.getMessage(),
			prize.getCountOfMatchedNumber(),
			formatter.format(prize.getReward()),
			countOfPrize));
	}

	private static void generateOtherPlaceResultOutputBuilder(final Prize prize,
		final Integer countOfPrize) {
		outputBuilder.append(String.format(OTHER_PLACE_RESULT_MESSAGE_FORMAT.getMessage(),
			prize.getCountOfMatchedNumber(),
			formatter.format(prize.getReward()),
			countOfPrize));
	}

	private static void generateTotalBenefitOutputBuilder(final LottoResult lottoResult,
		final Cash cash) {
		outputBuilder.append(String.format(TOTAL_BENEFIT_MESSAGE_FORMAT.getMessage(),
			lottoResult.getRoundedTotalBenefit(cash.getDepositAmount())));
	}

	public static void printErrorMessage(final Exception e) {
		initOutputBuilder();
		outputBuilder.append(e.getMessage())
			.append(ENTER.getUnit());
		printOutputBuilder();
	}

	private static void printOutputBuilder() {
		System.out.print(outputBuilder);
	}


	private static void initOutputBuilder() {
		outputBuilder.setLength(INIT_BUILDER_SIZE);
	}
}
