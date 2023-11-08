package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {
    private final static Pattern NUNBER_PATTERN = Pattern.compile("^[\\d]*$");
    private final static Pattern LOTTO_PATTERN = Pattern.compile("^([\\d]+,){5}+([\\d]+){1}$");

    public static String takeInputPrice() {
        try {
            return getInputPrice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeInputPrice();
        }
    }

    private static String getInputPrice() {
        System.out.println("구입금액을 입력해 주세요");
        String price = Console.readLine();
        if (!NUNBER_PATTERN.matcher(price).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 구매금액 형식이 아닙니다.");
        }
        return price;
    }

    public static String takeWinningNumbers() {
        try {
            return getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeWinningNumbers();
        }
    }

    private static String getWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        if (!LOTTO_PATTERN.matcher(numbers).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식이 아닙니다.");
        }
        return numbers;
    }

    public static String takeBonusNumber() {
        try {
            return getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeBonusNumber();
        }
    }

    private static String getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        if (!NUNBER_PATTERN.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다.");
        }
        return bonusNumber;
    }
}
