package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Issue {
    private int lottoQuantity;
    private List<Lotto> lottoGroup;

    void inputCash() {
        int cash = Integer.parseInt(Console.readLine());
        lottoQuantity = cash / 1000;
    }

    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    void makeSortedLotto() {
        for (int i = 0; i == lottoQuantity; i++) {
            Lotto transfer = new Lotto(getNumbers());

            transfer.sort();
            lottoGroup.add(transfer);
        }
    }

    void printLotto() {
        for (int i = 0; i < lottoGroup.size(); i++) {
            System.out.println(lottoGroup.get(i));
        }
    }

    void playIssue() {
        inputCash();
        makeSortedLotto();
        printLotto();
    }
}
