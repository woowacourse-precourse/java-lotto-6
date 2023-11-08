package lotto.view;

import java.util.List;
import lotto.domain.Prize;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.StatisticsDto;

public class OutputViewImpl implements OutputView {
    private final String PURCHASE_START_MESSAGE = "%d개를 구매했습니다.";
    private final String STATISTICS_START_MESSAGE = "당첨 통계\n---";
    private final String FIFTH_PRIZE_MESSAGE = "3개 일치 (%,d원) - %d개\n";
    private final String FORTH_PRIZE_MESSAGE = "4개 일치 (%,d원) - %d개\n";
    private final String THIRD_PRIZE_MESSAGE = "5개 일치 (%,d원) - %d개\n";
    private final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private final String FIRST_PRIZE_MESSAGE = "6개 일치 (%,d원) - %d개\n";
    private final String ROR_MESSAGE = "총 수익률은 %.1f%입니다.";

    @Override
    public void printPurchase(LottosDto lottosDto) {
        List<String> lottosToString = lottosDto.getLottosToString();
        printPurchaseStartMessage();
        for (String lottoString : lottosToString) {
            System.out.println(lottoString);
        }
    }

    private void printPurchaseStartMessage() {
        System.out.println(PURCHASE_START_MESSAGE);
    }

    @Override
    public void printStatistics(StatisticsDto statisticsDto) {
        printStatisticsStartMessage();
        printFifthPrizeMessage(statisticsDto.getFifth());
        printForthPrizeMessage(statisticsDto.getForth());
        printThirdPrizeMessage(statisticsDto.getThird());
        printSecondPrizeMessage(statisticsDto.getSecond());
        printFirstPrizeMessage(statisticsDto.getFirst());
        printRoRMessage(statisticsDto.getRor());
    }

    private void printFirstPrizeMessage(int first) {
        System.out.printf(FIRST_PRIZE_MESSAGE, Prize.FIRST.getReward(), first);
    }

    private void printSecondPrizeMessage(int second) {
        System.out.printf(SECOND_PRIZE_MESSAGE, Prize.SECOND.getReward(), second);
    }

    private void printThirdPrizeMessage(int third) {
        System.out.printf(THIRD_PRIZE_MESSAGE, Prize.THIRD.getReward(), third);
    }

    private void printForthPrizeMessage(int forth) {
        System.out.printf(FORTH_PRIZE_MESSAGE, Prize.FORTH.getReward(), forth);
    }

    private void printFifthPrizeMessage(int fifth) {
        System.out.printf(FIFTH_PRIZE_MESSAGE, Prize.FIFTH.getReward(), fifth);
    }

    private void printRoRMessage(float ror) {
        System.out.printf(ROR_MESSAGE, ror);
    }

    @Override
    public void printNewLineForSeparation() {
        System.out.println();
    }

    private void printStatisticsStartMessage() {
        System.out.println(STATISTICS_START_MESSAGE);
    }
}
