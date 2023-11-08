package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.util.Constant;

public class OutputView {

    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_RESULT_MESSAGE = "당첨 통계\n---";
    public static final String MONEY_PATTERN = "###,###";
    public static final String SECOND_RANK_MESSAGE = "일치, 보너스 볼 일치";
    public static final String NOT_SECOND_RANK_MESSAGE = "일치";

    public void printInputMoneyMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printInputWinningNumbersMessage() {
        System.out.println();
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printInputBonusNumberMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printLottoNumbers(List<List<Integer>> lottosNumbers) {
        System.out.printf("\n%s개를 구매했습니다.%n", lottosNumbers.size());
        for (List<Integer> lottoNumbers : lottosNumbers) {
            System.out.println(lottoNumbers);
        }
    }

    public void printRanksCount(Map<LottoRank, Integer> rankCount) {
        System.out.println();
        System.out.println(WINNING_RESULT_MESSAGE);
        DecimalFormat formatter = new DecimalFormat(MONEY_PATTERN);

        for (LottoRank lottoRank : rankCount.keySet()) {
            printEachRank(rankCount, lottoRank, formatter);
        }
    }

    public void printRateOfProfits(Map<LottoRank, Integer> rankCount) {
        int lottoCount = getLottoCount(rankCount);
        double inMoney = lottoCount * Constant.LOTTO_PRICE;
        double outMoney = getOutMoney(rankCount);
        double rateOfProfit = Math.round(outMoney / inMoney * 1000.0) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfProfit);
    }

    private void printEachRank(Map<LottoRank, Integer> rankCount, LottoRank lottoRank, DecimalFormat formatter) {
        if (lottoRank == LottoRank.NONE) {
            return;
        }
        int matchCount = lottoRank.getMatchCount();
        String message = getMessage(lottoRank);
        String prize = formatter.format(lottoRank.getPrize());
        int count = rankCount.get(lottoRank);
        System.out.printf("%d개 %s (%s원) - %d개\n", matchCount, message, prize, count);
    }

    private String getMessage(LottoRank lottoRank) {
        if (lottoRank == LottoRank.SECOND) {
            return SECOND_RANK_MESSAGE;
        }
        return NOT_SECOND_RANK_MESSAGE;
    }

    private static double getOutMoney(Map<LottoRank, Integer> rankCount) {
        return rankCount.keySet()
                .stream()
                .mapToDouble(rank -> rank.getPrize() * rankCount.get(rank))
                .sum();
    }

    private int getLottoCount(Map<LottoRank, Integer> rankCount) {
        return rankCount.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
