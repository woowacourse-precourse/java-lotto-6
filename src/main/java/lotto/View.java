package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {

    public static String getUserInput() {
        String userInput = Console.readLine();
        System.out.println();
        return userInput;
    }

    public static void printMessage(Notice notice) {
        System.out.println(notice.getMessage());
    }

    public static void printLotteryCount(Integer lotteryCount) {
        System.out.println(lotteryCount + "개를 구매했습니다.");
    }

    public static void printLotteryNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
