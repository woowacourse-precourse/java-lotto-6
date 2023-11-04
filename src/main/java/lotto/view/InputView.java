package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPurchaseAmount(){
        String purchaseAmount = Console.readLine();
        validateNotEmpty(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private static void validateNotEmpty(String purchaseAmount) {
        if(purchaseAmount.isEmpty()){
            throw new IllegalArgumentException("[ERROR] : 입력 값은 공백일 수 없습니다");
        }
    }

}
