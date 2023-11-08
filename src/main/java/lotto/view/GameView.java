package lotto.view;

import static lotto.view.constants.ConstantMessage.ASK_LOTTO_PURCHASE_AMOUNT;
import static lotto.view.constants.ConstantMessage.ASK_WINNING_LOTTO_BONUS_NUMBER;
import static lotto.view.constants.ConstantMessage.ASK_WINNING_LOTTO_NUMBERS;
import static lotto.view.constants.ConstantMessage.DISPLAY_LOTTO_PURCHASE_COUNT;
import static lotto.view.constants.ConstantMessage.FIFTH_RANKING_COUNT_MESSAGE;
import static lotto.view.constants.ConstantMessage.FOURTH_RANKING_COUNT_MESSAGE;
import static lotto.view.constants.ConstantMessage.THIRD_RANKING_COUNT_MESSAGE;
import static lotto.view.constants.ConstantMessage.SECOND_RANKING_COUNT_MESSAGE;
import static lotto.view.constants.ConstantMessage.FIRST_RANKING_COUNT_MESSAGE;
import static lotto.view.constants.ConstantMessage.WINNING_STATISTICS_MESSAGE;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.constants.ConstantMessage;

public class GameView {

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.print(constantMessage.getMessage());
    }

    public static void printlnEmpty() {
        System.out.println();
    }

    public static String inputLottoPurchaseAmount() {
        printConstantMessage(ASK_LOTTO_PURCHASE_AMOUNT);
        printlnEmpty();
        return Console.readLine();
    }

    public static void printLottoCount(int lottoPurchaseCount) {
        printlnEmpty();
        System.out.print(lottoPurchaseCount);
        printConstantMessage(DISPLAY_LOTTO_PURCHASE_COUNT);
        printlnEmpty();
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static String inputLottoNumbers() {
        printlnEmpty();
        printConstantMessage(ASK_WINNING_LOTTO_NUMBERS);
        printlnEmpty();
        return Console.readLine();
    }

    public static String inputLottoBonusNumber() {
        printlnEmpty();
        printConstantMessage(ASK_WINNING_LOTTO_BONUS_NUMBER);
        printlnEmpty();
        return Console.readLine();
    }

    public static void printTotalRankingCount() {
        printlnEmpty();
        printConstantMessage(WINNING_STATISTICS_MESSAGE);
        printlnEmpty();
        System.out.println("---");
    }

    public static void printFifthRankingCount(int fifthPlaceCount) {
        printConstantMessage(FIFTH_RANKING_COUNT_MESSAGE);
        System.out.printf("%d개", fifthPlaceCount);
        printlnEmpty();
    }

    public static void printFourthRankingCount(int fourthPlaceCount) {
        printConstantMessage(FOURTH_RANKING_COUNT_MESSAGE);
        System.out.printf("%d개", fourthPlaceCount);
        printlnEmpty();
    }

    public static void printThirdRankingCount(int thirdPlaceCount) {
        printConstantMessage(THIRD_RANKING_COUNT_MESSAGE);
        System.out.printf("%d개", thirdPlaceCount);
        printlnEmpty();
    }

    public static void printSecondRankingCount(int secondPlaceCount) {
        printConstantMessage(SECOND_RANKING_COUNT_MESSAGE);
        System.out.printf("%d개", secondPlaceCount);
        printlnEmpty();
    }

    public static void printFirstRankingCount(int firstPlaceCount) {
        printConstantMessage(FIRST_RANKING_COUNT_MESSAGE);
        System.out.printf("%d개", firstPlaceCount);
        printlnEmpty();
    }

    public static void printReturnRate(float returnRate) {
        if (returnRate % 1 == 0) {
            System.out.printf("총 수익률은 %.0f%%입니다.", returnRate);
            return;
        }
        if (returnRate * 10 % 1 == 0) {
            System.out.printf("총 수익률은 %.1f%%입니다.", returnRate);
            return;
        }
        if(returnRate * 100 % 1 == 0) {
            System.out.printf("총 수익률은 %.2f%%입니다.", returnRate);
        }
    }

}

