package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.util.Constant;

public class OutputView {
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinningNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printLottoNumbers(List<List<Integer>> lottosNumbers) {
        System.out.printf("\n%s개를 구매했습니다.%n", lottosNumbers.size());
        for (List<Integer> lottoNumbers : lottosNumbers) {
            System.out.println(lottoNumbers);
        }
    }

    public void printRanksCount(Map<LottoRank, Integer> rankCount) {
        System.out.println("\n당첨 통계\n---");
        DecimalFormat formatter = new DecimalFormat("###,###");

        for (LottoRank lottoRank : rankCount.keySet()) {
            if (lottoRank == LottoRank.NONE) {
                continue;
            }
            int matchCount = lottoRank.getMatchCount();
            String message = getMessage(lottoRank);
            String prize = formatter.format(lottoRank.getPrize());
            int count = rankCount.get(lottoRank);
            System.out.printf("%d개 %s (%s원) - %d개\n", matchCount, message, prize, count);
        }
    }

    private String getMessage(LottoRank lottoRank) {
        if (lottoRank == LottoRank.SECOND) {
            return "일치, 보너스 볼 일치";
        }
        return "일치";
    }

    public void printRateOfProfits(Map<LottoRank, Integer> rankCount) {
        int lottoCount = getLottoCount(rankCount);
        double inMoney = lottoCount * Constant.LOTTO_PRICE;
        double outMoney = rankCount.keySet()
                .stream()
                .mapToDouble(rank -> rank.getPrize() * rankCount.get(rank))
                .sum();
        double rateOfProfit = Math.round(outMoney / inMoney * 1000.0) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfProfit);
    }

    private int getLottoCount(Map<LottoRank, Integer> rankCount) {
        return rankCount.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
