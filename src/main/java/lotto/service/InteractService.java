package lotto.service;

import static lotto.domain.ExceptionModule.checkParseIntException;
import static lotto.domain.ExceptionModule.checkThousandException;

import camp.nextstep.edu.missionutils.Console;

public class InteractService {

    private static final Integer LOTTO_PRICE = 1000;

    public static Integer purchasePhase() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                Integer tryNum = checkParseIntException(Console.readLine());
                checkThousandException(tryNum, LOTTO_PRICE);
                return tryNum;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구입 금액은 1000원의 양의 정수배만 입력 가능합니다.");
            }
        }
    }
}
