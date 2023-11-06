package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public void askAmount() {
        print("구입금액을 입력해 주세요.");
    }

    public void showTickets(int count) {
        print(count + "개를 구매했습니다.");
    }

    public void askWinningNum() {
        print("당첨 번호를 입력해주세요.");
    }

    public void askBonusNum() {
        print("보너스 번호를 입력해주세요.");
    }

    public void showLottoList(final Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        System.out.println();
        lottoList.forEach(System.out::println);
    }

    public void showResults() {
        print("당첨 통계\n---");
    }

    public void showYield(double yield) {
        print("총 수익률은 %.1f%%입니다.", yield);
    }

    private void print(String str) {
        System.out.println(str);
    }

    private void print(String str, double yield) {
        System.out.printf(str, yield);
    }

    private void print(int count, String str) {
        System.out.println(count + str);
    }
}
