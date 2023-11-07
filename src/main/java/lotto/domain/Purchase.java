package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputPurchaseAmount = Integer.parseInt(Console.readLine());
        validateInputPurchaseAmount(inputPurchaseAmount);
        System.out.println();
        return inputPurchaseAmount;
    }

    public void validateInputPurchaseAmount(int inputPurchaseAmount){
        if (inputPurchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public int calculateRound(int inputPurchaseAmount) {
        int round = inputPurchaseAmount / 1000;
        System.out.println(round + "개를 구매했습니다.");
        return round;
    }
}
