package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int input = 0;
    private static int buyCount = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputPurchaseMoney();

    }


    private static void inputPurchaseMoney() {
        try {
            validatePurchaseMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseMoney();
        }
    }

    private static void validatePurchaseMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            input = Integer.parseInt(Console.readLine());
            buyCount = input / 1000;
            System.out.println(buyCount + "개를 구매했습니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

}
