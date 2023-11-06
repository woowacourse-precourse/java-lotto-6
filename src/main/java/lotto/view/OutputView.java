package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final int LOTTO_SIZE = 6;

    public void printPurchaseAmount(long purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
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
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
