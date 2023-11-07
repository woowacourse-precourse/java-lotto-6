package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;

public class WinningNumbersInput {

    public static int getNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수형의 수를 입력 바랍니다.");
        }
    }

    public static BonusNumber bonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonus = Console.readLine();
            int bonusNumber = getNumber(bonus);
            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return bonusNumber();
        }
    }

    public static WinningNumbers winningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
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
            System.out.println("[ERROR] " + e.getMessage());
            return winningNumbers();
        }
    }
}
