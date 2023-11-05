package lotto.view;

import lotto.CommonMessages;
import lotto.Lotto;

import java.util.HashMap;
import java.util.List;

import static lotto.CommonMessages.*;

public class OutputView {

    public void printPurchaseAmount(Integer amount) {

        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {

            String numbers = lotto.getNumbers().toString();
            System.out.println(String.join(", ", numbers));
        }
    }

    public void printResult(HashMap<Integer,Integer> result) {



    }
}
