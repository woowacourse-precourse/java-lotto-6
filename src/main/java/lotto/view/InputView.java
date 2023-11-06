package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Validation;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoConst.*;

public class InputView {

    Validation validation = new Validation();

    public int inputPurchaseMoney() {
        try {
            System.out.println(INPUT_PURCHASE_MONEY);
            String input = Console.readLine();
            return validation.validatePurchaseMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseMoney();
        }
    }

    public WinningNumbers inputWinningNums() {
        try {
            System.out.println(INPUT_WINNING_NUMS);
            List<Integer> winningNums = new ArrayList<>();
            String inputWinningNums = Console.readLine();
            String[] split = inputWinningNums.split(",");
            for (int i = 0; i < split.length; i++) {
                winningNums.add(Integer.parseInt(split[i]));
            }

            return new WinningNumbers(winningNums, createBonusNum());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNums();
        }
    }

    private int createBonusNum() {
        System.out.println(INPUT_BONUS_NUM);
        return Integer.parseInt(Console.readLine());
    }
}
