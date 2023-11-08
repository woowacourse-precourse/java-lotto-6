package lotto.service;

import static lotto.domain.ExceptionModule.*;
import static lotto.domain.InteractModule.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Enum.Winning;
import lotto.domain.Generator;
import lotto.domain.Lotto;

public class InteractService {

    private static final Integer LOTTO_PRICE = 1000;

    public static Integer purchasePhase() {
        while (true) {
            printPurchaseNotice();

            try {
                Integer tryNum = checkParseIntException(Console.readLine());
                checkNegative(tryNum);
                checkThousandException(tryNum, LOTTO_PRICE);
                return tryNum;
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    public static List<Lotto> lottoGeneratePhase(Integer tryNum) {
        int lottoCount = tryNum / LOTTO_PRICE;
        printLottoGenerateNotice(lottoCount);

        List<Lotto> generateLotto = Generator.generateLotto(lottoCount);
        checkLottoCount(generateLotto.size(), lottoCount);
        return generateLotto;
    }

    public static List<Integer> winningNumPhase() {
        while (true) {
            printWinningNumNotice();

            try {
                List<Integer> winningNum = splitWinningNum();
                checkWinningNumDubAndSize(winningNum);
                return winningNum;
            } catch (IllegalArgumentException e) {
                printError(e);
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

    public static Integer bonusNumPhase(List<Integer> winningNum) {
        while (true) {
            printBonusNotice();
            try {
                Integer bonusNum = checkParseIntException(Console.readLine());
                checkNumBoundary(bonusNum);
                checkBonusNumDub(bonusNum, winningNum);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    public static void resultPhase(List<Integer> result, Integer tryNum) {
        printResultNotice();

        int total = 0;

        for (Winning winning : Winning.values()) {
            printResult(winning, result.get(0));
            total += winning.getAmount() * result.get(0);
            result.remove(0);
        }

        printRateOfReturn(total, tryNum);
    }
}
