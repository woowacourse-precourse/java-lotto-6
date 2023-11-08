package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class LottoInputHandler {
    public int getPurchaseAmount() {
        int purchaseAmount = 0;
        boolean isValidAmount = false;
        boolean isNumeric = false;
        while (!isValidAmount) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                for (int i = 0; i < input.length(); i++) {
                    if (!Character.isDigit(input.charAt(i))) {
                        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
                    }
                    isNumeric = true;
                }
                purchaseAmount = Integer.parseInt(input);

                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
                }
                isValidAmount = true;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
        return purchaseAmount;
    }
}
