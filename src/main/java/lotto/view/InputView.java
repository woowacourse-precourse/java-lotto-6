package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String INVALID_INPUT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String NUMBER_SPLITTER = ",";

    public static Money inputMoney() {
        try {
            System.out.println(INPUT_MONEY_MESSAGE);
            return Money.from(toInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private static int toInt(String inputMoneyAmount) {
        try {
            return Integer.parseInt(inputMoneyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static Lotto inputWinNumber() {
        try {
            System.out.println(INPUT_WIN_NUMBER_MESSAGE);
            return new Lotto(toList(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinNumber();
        }
    }

    public static WinNumber inputBonusNumber(Lotto winLotto) {
        try {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            int bonusNumber = toInt(Console.readLine());
            return WinNumber.from(winLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winLotto);
        }
    }

    private static List<Integer> toList(String inputWinNumbers) {
        try {
            return Arrays.stream(inputWinNumbers.split(NUMBER_SPLITTER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_ERROR_MESSAGE);
        }
    }
}
