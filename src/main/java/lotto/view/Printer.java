package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class Printer {
    public static void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }

    public static void printInputLottoPurchasePayment(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfPurchaseLotto(int numberOfPurchaseLotto){
        System.out.println(numberOfPurchaseLotto + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }
}
