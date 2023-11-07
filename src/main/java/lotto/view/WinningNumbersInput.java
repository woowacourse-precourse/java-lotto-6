package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;

public class WinningNumbersInput {

    private static final String ERROR_ALARM = "[ERROR] ";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int getNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수형 수를 입력해주세요.");
        }
    }

    public static BonusNumber bonusNumber() {
        try {
            System.out.println(INPUT_BONUS_NUMBER);
            String bonus = Console.readLine();
            int bonusNumber = getNumber(bonus);
            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_ALARM + e.getMessage());
            return bonusNumber();
        }
    }

    public static WinningNumbers winningNumbers() {
        try {
            System.out.println(INPUT_WINNING_NUMBERS);
            String input = Console.readLine();
            String[] inputArr = input.split(",");
            List<Integer> lottoList = new ArrayList<>();
            for (String str : inputArr) {
                lottoList.add(getNumber(str));
            }
            System.out.println();
            BonusNumber bonusNumber = bonusNumber();
            return new WinningNumbers(lottoList, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_ALARM + e.getMessage());
            return winningNumbers();
        }
    }
}
