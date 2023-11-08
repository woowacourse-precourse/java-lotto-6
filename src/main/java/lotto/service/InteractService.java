package lotto.service;

import static lotto.domain.ExceptionModule.checkBonusNumDub;
import static lotto.domain.ExceptionModule.checkLottoCount;
import static lotto.domain.ExceptionModule.checkNegative;
import static lotto.domain.ExceptionModule.checkNumBoundary;
import static lotto.domain.ExceptionModule.checkParseIntException;
import static lotto.domain.ExceptionModule.checkThousandException;
import static lotto.domain.ExceptionModule.checkWinningNumDubAndSize;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Generator;
import lotto.domain.Lotto;

public class InteractService {

    private static final Integer LOTTO_PRICE = 1000;

    public static Integer purchasePhase() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");

            try {
                Integer tryNum = checkParseIntException(Console.readLine());
                checkNegative(tryNum);
                checkThousandException(tryNum, LOTTO_PRICE);
                return tryNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> winningNumPhase() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");

            try {
                List<Integer> winningNum = splitWinningNum();
                checkWinningNumDubAndSize(winningNum);
                return winningNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Integer bonusNumPhase(List<Integer> winningNum) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");

            try {
                Integer bonusNum = checkParseIntException(Console.readLine());
                checkNumBoundary(bonusNum);
                checkBonusNumDub(bonusNum, winningNum);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
