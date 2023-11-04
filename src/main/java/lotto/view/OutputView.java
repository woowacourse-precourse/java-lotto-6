package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public int printPurchases(int numberOfLotto) {
        int number = numberOfLotto / 1000;
        System.out.println(number + "개를 구매했습니다.");
        return number;
    }

    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for(Lotto lotto : issuedLotto) {
            String result = Arrays.toString(lotto.getNumbers().toArray());
            System.out.println(result);
        }
    }
}
