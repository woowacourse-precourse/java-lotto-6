package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 최초 커밋 테스트
    }

    public static String inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseAmount = Console.readLine();
        return inputPurchaseAmount;
    }

    public  int inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            return purchaseAmount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000 ");
        }
    }
}
