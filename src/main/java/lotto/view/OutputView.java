package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import static lotto.util.CharacterUnits.ENTER;
import static lotto.util.CharacterUnits.LINE;
import static lotto.util.PatternUnits.PATTERN_FOR_DECIMAL_FORMAT;

public class OutputView {

    private final DecimalFormat formatter;
    private final StringBuilder outputBuilder;
    public OutputView() {
        formatter = new DecimalFormat(PATTERN_FOR_DECIMAL_FORMAT.getPattern());
        outputBuilder = new StringBuilder();
    }

    public void printPurchasedLottos(Lottos lottos) {
        initOutputBuilder();
        generatePurchasedLottosOutputBuilder(lottos);
        printOutputBuilder();

    }

    private void generatePurchasedLottosOutputBuilder(Lottos lottos) {
        outputBuilder.append(ENTER.getUnit())
                .append(String.format("%d개를 구매했습니다.", lottos.getCount()))
                .append(ENTER.getUnit());

        for (Lotto lotto : lottos.getLottos()) {
            outputBuilder.append(lotto.toString())
                    .append(ENTER.getUnit());
        }
    }

    public void printStaticResult(Prizes prizes, Cash cash) {
        initOutputBuilder();
        generateStaticResultOutputBuilder(prizes);
        generateTotalBenefitOutputBuilder(prizes, cash);
        printOutputBuilder();
    }

    private void generateStaticResultOutputBuilder(Prizes prizes) {
        outputBuilder.append("당첨 통계")
                .append(LINE.getUnit());
        for (Prize prize : Prize.values()) {
            generateRankingResultOutputBuilder(prize, prizes.countPrize(prize));
            outputBuilder.append(ENTER.getUnit());
        }
    }

    private void generateRankingResultOutputBuilder(Prize prize, Integer countOfPrize) {
        if (prize.isBonusNumber()) {
            generateSecondPlaceResultOutputBuilder(prize, countOfPrize);
        } else if (!prize.isBonusNumber() && prize != Prize.LAST_PLACE) {
            generateOtherPlaceResultOutputBuilder(prize, countOfPrize);
        }

    }

    private void generateSecondPlaceResultOutputBuilder(Prize prize, Integer countOfPrize) {
        outputBuilder.append(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                prize.getCountOfMatchedNumber(),
                formatter.format(prize.getReward()),
                countOfPrize));
    }

    private void generateOtherPlaceResultOutputBuilder(Prize prize, Integer countOfPrize) {
        outputBuilder.append(String.format("%d개 일치 (%s원) - %d개",
                prize.getCountOfMatchedNumber(),
                formatter.format(prize.getReward()),
                countOfPrize));
    }

    private void generateTotalBenefitOutputBuilder(Prizes prizes, Cash cash) {
        outputBuilder.append(String.format("총 수익률은 %.1f", prizes.getRoundedTotalBenefit(cash.getDepositAmount())));
        outputBuilder.append("%입니다.");
    }

    public void printErrorMessage(Exception e) {
        initOutputBuilder();
        outputBuilder.append(e.getMessage())
                     .append(ENTER.getUnit());
        printOutputBuilder();
    }

    private void printOutputBuilder() {
        System.out.print(outputBuilder);
    }


    private void initOutputBuilder() {
        outputBuilder.setLength(0);
    }
}
