package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class UI {
    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public void printPurchases(List<Lotto> lottos) {
        System.out.println("8개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for (int i = 0; i < Lotto.size; i++) {
            System.out.print(numbers.get(i));
            if (i < Lotto.size - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
