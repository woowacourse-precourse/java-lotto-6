package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class PurchasedLottoesView {
    // 구매한 로또 내역을 보여줄 클래스입니다.
    public void printNumberOfIssues(long numberOfIssues) {
        System.out.println("\n" + numberOfIssues + "개를 구매했습니다.");
    }

    public void printPurchasedLottoes(List<Lotto> lottoes) {
        for (int i = 0; i < lottoes.size(); i++) {
            printLottoNumber(lottoes.get(i));
        }
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
