package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void showPurchasedLotto(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public void showWinningStatistics(WinningDto winningDto) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + winningDto.getCountThree() + "개");
        System.out.println("4개 일치 (50,000원) - " + winningDto.getCountFour() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningDto.getCountFive() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningDto.getCountFivePlusBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningDto.getCountSix() + "개");
        System.out.println("총 수익률은 " + winningDto.getEarningRate() + "%입니다.");
    }
}
