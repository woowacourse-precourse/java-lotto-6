package lotto.service;

import static lotto.domain.ExceptionModule.checkNumBoundary;
import static lotto.domain.ExceptionModule.checkParseIntException;
import static lotto.domain.ExceptionModule.checkThousandException;
import static lotto.domain.ExceptionModule.checkWinningNumDub;
import static lotto.domain.ExceptionModule.checkWinningNumSize;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Integer> winningNumPhase() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                List<Integer> winningNum = splitWinningNum();
                checkWinningNumDub(winningNum);
                checkWinningNumSize(winningNum);
                return winningNum;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자여야 합니다.");
            }
        }
    }

    private static List<Integer> splitWinningNum() throws IllegalArgumentException{
        List<Integer> winningNum = new ArrayList<>();
        for (String s : Console.readLine().split(",")) {
            Integer numElement = checkParseIntException(s);
            checkNumBoundary(numElement);
            winningNum.add(numElement);
        }
        return winningNum;
    }
}
