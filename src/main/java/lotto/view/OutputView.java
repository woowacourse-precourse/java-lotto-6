package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        print();
    }

    public void askAmount() {
        print("구입금액을 입력해 주세요.");
    }

    public void showTickets(final int count) {
        print();
        print(count + "개를 구매했습니다.");
    }

    public void askWinningNum() {
        print("당첨 번호를 입력해주세요.");
    }

    public void askBonusNum() {
        print();
        print("보너스 번호를 입력해주세요.");
    }

    public void showLottoList(final Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        lottoList.forEach(System.out::println);
        print();
    }

    public void showResults(final String str) {
        print();
        print("당첨 통계");
        print("---");
        print(str);
    }

    public void showYield(final double yield) {
        printYield(yield);
    }

    private void print() {
        System.out.println();
    }

    private void print(final String str) {
        System.out.println(str);
    }

    private void printYield(final double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
