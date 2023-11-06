package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public static void printPurchaseAmountMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCntMessage(int lottoCnt){
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }

    public static void printLottosMessage(List<Lotto> lottos){
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

}
