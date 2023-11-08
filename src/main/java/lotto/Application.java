package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int lottoAmount = askAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = -1;
        try {
            amount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        return amount;
    }

}
