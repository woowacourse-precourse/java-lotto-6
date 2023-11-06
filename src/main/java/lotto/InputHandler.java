package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine().trim());
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 가능합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("로또 구입금액은 하나의 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}