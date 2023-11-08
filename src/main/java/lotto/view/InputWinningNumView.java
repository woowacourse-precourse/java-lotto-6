package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.ConvertStringToNum;

public class InputWinningNumView {
    public List<Integer> printWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        List<Integer> winningNums = validateInputWinningNum(input);
        return winningNums;
    }

    public int printBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        int bonusNum = validateInputBonusNum(input);
        return bonusNum;
    }

    private List<Integer> validateInputWinningNum(String input) {
        String[] nums = input.split(",");
        int numberOfComma = nums.length - 1;
        if (numberOfComma != 5) {
            throw new IllegalArgumentException("5개의 숫자를 입력해주세요");
        }
        return ConvertStringToNum.toNum(nums);
    }

    private int validateInputBonusNum(String input) {
        if (ConvertStringToNum.isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException("올바른 보너스 숫자를 입력해주세요");
    }
}
