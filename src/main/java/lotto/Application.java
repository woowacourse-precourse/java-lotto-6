package lotto;

import static lotto.UserInputHandler.getLottoPurchaseAmount;
import static lotto.UserInputHandler.requestPurchaseAmount;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        requestPurchaseAmount();
        int purchaseAmount = getLottoPurchaseAmount();
        int purchaseQuantity = purchaseAmount / 1000;
        System.out.println(purchaseQuantity+"개를 구매했습니다.");
    }
}
