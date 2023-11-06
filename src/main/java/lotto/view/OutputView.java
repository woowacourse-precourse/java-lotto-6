package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import static lotto.util.CharacterUnits.ENTER;
import static lotto.util.CharacterUnits.LINE;
import static lotto.util.PatternUnits.PATTERN_FOR_DECIMAL_FORMAT;
import static lotto.view.OutputViewMessage.*;

public class OutputView {

    private static final Integer INIT_BUILDER_SIZE = 0;
    private static final DecimalFormat formatter = new DecimalFormat(PATTERN_FOR_DECIMAL_FORMAT.getPattern());;
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

        for (Lotto lotto : lottos.getLottos()) {
            outputBuilder.append(lotto.toString())
                    .append(ENTER.getUnit());
        }
    }

    public static void printStaticResult(final Prizes prizes, final Cash cash) {
        initOutputBuilder();
        generateStaticResultOutputBuilder(prizes);
        generateTotalBenefitOutputBuilder(prizes, cash);
        printOutputBuilder();
    }

    private static void generateStaticResultOutputBuilder(final Prizes prizes) {
        outputBuilder.append(WINNING_STATIC_MESSAGE.getMessage());
        for (Prize prize : Prize.values()) {
            generateRankingResultOutputBuilder(prize,
                    prizes.countPrize(prize));
            outputBuilder.append(ENTER.getUnit());
        }
    }

    private static void generateRankingResultOutputBuilder(final Prize prize, final Integer countOfPrize) {
        if (prize.isBonusNumber()) {
            generateSecondPlaceResultOutputBuilder(prize, countOfPrize);
        } else if (!prize.isBonusNumber() && prize != Prize.LAST_PLACE) {
            generateOtherPlaceResultOutputBuilder(prize, countOfPrize);
        }

    }

    private static void generateSecondPlaceResultOutputBuilder(final Prize prize, final Integer countOfPrize) {
        outputBuilder.append(String.format(SECOND_PLACE_RESULT_MESSAGE_FORMAT.getMessage(),
                prize.getCountOfMatchedNumber(),
                formatter.format(prize.getReward()),
                countOfPrize));
    }

    private static void generateOtherPlaceResultOutputBuilder(final Prize prize, final Integer countOfPrize) {
        outputBuilder.append(String.format(OTHER_PLACE_RESULT_MESSAGE_FORMAT.getMessage(),
                prize.getCountOfMatchedNumber(),
                formatter.format(prize.getReward()),
                countOfPrize));
    }

    private static void generateTotalBenefitOutputBuilder(final Prizes prizes, final Cash cash) {
        outputBuilder.append(String.format(TOTAL_BENEFIT_MESSAGE_FORMAT.getMessage(), prizes.getRoundedTotalBenefit(cash.getDepositAmount())));
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
