package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    private final String PURCHASES_NUMBER = "개를 구매했습니다.";

    public void purchasesNumberView(int AMOUNT){
        System.out.println("\n" + AMOUNT + PURCHASES_NUMBER);
    }

    public void lottosView(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}