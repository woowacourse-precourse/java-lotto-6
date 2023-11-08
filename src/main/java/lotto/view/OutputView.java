package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningPrize;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void showLottosNumber(int amount, Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();

        System.out.println(amount +"개를 구매했습니다.");
        lottoList.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public static void printWinningResult(Map<WinningPrize, Integer> winningStatus, double earningsRate) {
        WinningPrize[] winningPrize = WinningPrize.values();
        System.out.println("당첨 통계\n---");

        for (WinningPrize prize : winningPrize) {
            System.out.println(String.format("%d개 일치 (%s원) - %d개", prize.getMatchedNumberCount(), prize.getFormatNumber(), winningStatus.get(prize.getMatchedNumberCount())));
        }

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningsRate));
    }
}
