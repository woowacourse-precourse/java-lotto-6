package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    private static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        validPurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }
    private static void validPurchaseAmount(int amount){
        
    }

}
