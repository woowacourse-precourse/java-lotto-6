package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.config.Constant;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;

public class WinningNumbersInput {

    public static int getNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.NUMBER_FORMAT_EXCEPTION);
        }
    }

    public static BonusNumber bonusNumber() {
        try {
            System.out.println(Constant.INPUT_BONUS_NUMBER);
            String bonus = Console.readLine();
            int bonusNumber = getNumber(bonus);
            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.ERROR_ALARM + e.getMessage());
            return bonusNumber();
        }
    }

    public static WinningNumbers winningNumbers() {
        try {
            System.out.println(Constant.INPUT_WINNING_NUMBERS);
            String input = Console.readLine();
            String[] inputArr = input.split(",");
            List<Integer> lottoList = new ArrayList<>();
            for (String str : inputArr) {
                lottoList.add(getNumber(str));
            }
            System.out.println();
            BonusNumber bonusNumber = bonusNumber();
            System.out.println();
            return new WinningNumbers(lottoList, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.ERROR_ALARM + e.getMessage());
            return winningNumbers();
        }
    }
}
