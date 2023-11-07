package lotto;

import static lotto.QuantityDisplayManager.printPurchaseQuantity;
import static lotto.UserInputHandler.getLottoPurchaseAmount;
import static lotto.UserInputHandler.inputWinningNumbers;
import static lotto.UserInputHandler.requestInputForWinningNumbers;
import static lotto.UserInputHandler.requestPurchaseAmount;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        requestPurchaseAmount();
        int purchaseAmount = getLottoPurchaseAmount();
        int purchaseQuantity = purchaseAmount / 1000;
        System.out.println(purchaseQuantity+"개를 구매했습니다.");
        List<List<Integer>> numbers = printPurchaseQuantity(purchaseQuantity);
        int i = 0;
        for(i = 0 ; i < purchaseQuantity ; i++){
            System.out.println(numbers.get(i));
        }
        requestInputForWinningNumbers();
        inputWinningNumbers();
    }
}
