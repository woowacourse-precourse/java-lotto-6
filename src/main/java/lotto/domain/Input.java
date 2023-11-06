package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTERY_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private Input() {
    }

    public static int askHowManyLottoPurchase() {
        while (true) {
            try {
                String sum = readPurchaseMoney();
                int money = validateType(sum);
                validateMoneyRange(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static String readPurchaseMoney() {
        System.out.println(PURCHASE_MESSAGE);
        return Console.readLine();
    }

    private static void validateMoneyRange(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력하시오");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하시오");
        }
    }


    public static List<Integer> askTheWinningLotteryNumbers() {
        while (true) {
            try {
                String numberString = readTheWinningLotteryNumbers();
                List<Integer> numbers = separateString(numberString);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readTheWinningLotteryNumbers() {
        System.out.println(WINNING_LOTTERY_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    private static List<Integer> separateString(String numberString) {
        return Arrays.stream(numberString.split(","))
                .map(Input::validateType)
                .collect(Collectors.toList());
    }

    public static int askBonusNumber() {
        while (true) {
            try {
                String bonus = readTheWinningLotteryBonusNumber();
                int bonusNumber = validateType(bonus);
                validateNumberRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readTheWinningLotteryBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

    private static void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }


    private static int validateType(String sum) {
        try {
            return Integer.parseInt(sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하십시오");
        }
    }
}
