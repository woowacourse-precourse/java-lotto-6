package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.WinnerPrice;
import lotto.domain.Lotto;

public class OutputView {
    public static final int LOTTO_SIZE = 6; // 로또의 길이 상수

    public void printPurchaseAmount(long purchaseAmount) {
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
    }

    public void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLotto(List<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            List<Integer> number = lotto.getNumbers();
            String output = "[";
            for (int j = 0; j < LOTTO_SIZE; j++) {
                output += number.get(j) + ", ";
            }
            output = eraserEnd(output);
            System.out.println(output);
        }
    }

    private String eraserEnd(String output) {
        String str = output.substring(0, output.length() - 2);
        str += "]";
        return str;
    }

    public void winnerNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void bonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void winningResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void result(Map<Integer, Integer> result) {
        WinnerPrice[] winnerPrices = WinnerPrice.values();
        for (int i = winnerPrices.length - 2; i >= 0; i--) {
            WinnerPrice winnerPrice = winnerPrices[i];
            int index = winnerPrice.getEqualCount();
            String price = winnerPrice.getPrintPrice();
            if (result.get(index) == null) {
                System.out.println(price + 0 + "개");
                continue;
            }
            System.out.println(price + result.get(index) + "개");
        }
    }

    public void rate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
