package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_BUY_LOTTO = "%d개를 구매했습니다.";

    public static void printNumberOfBuyLotto(int numberOfLottoBuy){
        System.out.printf(NUMBER_OF_BUY_LOTTO,numberOfLottoBuy);
    }

    public static void printLottoNums(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }


}
