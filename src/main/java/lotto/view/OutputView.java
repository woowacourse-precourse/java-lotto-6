package lotto.view;

import lotto.Lotto;
import lotto.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void lottoAmount(final long lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void showLottos(final List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void requestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void prizeResult(Map<Prize, Integer> result) {
        System.out.println("당첨 통계\n" + "---");

        this.prizeWinCount(Prize.FIFTH, result.get(Prize.FIFTH));
        this.prizeWinCount(Prize.FOURTH, result.get(Prize.FOURTH));
        this.prizeWinCount(Prize.THIRD, result.get(Prize.THIRD));
        this.prizeWinCount(Prize.SECOND, result.get(Prize.SECOND));
        this.prizeWinCount(Prize.FIRST, result.get(Prize.FIRST));
    }

    public void profitRate(final String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public void prizeWinCount(Prize prize, int count) {
        System.out.println(Prize.prizeInfo(prize) + " - " + count + "개");
    }
}
