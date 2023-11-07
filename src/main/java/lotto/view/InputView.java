package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InputException;

public class InputView {

    private final static String READ_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private final static String READ_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String READ_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public int readPurchaseMoney() {
        System.out.println(READ_PURCHASE_MONEY);
        String purchaseMoney = Console.readLine();
        validateInteger(purchaseMoney);
        return Integer.parseInt(purchaseMoney);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(READ_WINNING_NUMBERS);
        String line = Console.readLine();
        String[] WinningNumbers = line.split(",");
        validateAllInteger(WinningNumbers);

        return Arrays.stream(WinningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readBonusNum() {
        System.out.println(READ_BONUS_NUM);
        String bonusNum = Console.readLine();
        validateInteger(bonusNum);
        return Integer.parseInt(bonusNum);
    }

    public void validateAllInteger(String[] strings) {
        for (String str : strings) {
            validateInteger(str);
        }
    }

    public void validateInteger(String str) {
        if (!str.matches("^-?\\d+$")) {
            throw new IllegalArgumentException(InputException.NOT_INTEGER.getExceptionMessage());
        }
    }
}
