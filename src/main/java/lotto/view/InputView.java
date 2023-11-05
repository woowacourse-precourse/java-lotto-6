package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Validation;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.Validation.*;

public class InputView {

    public int inputPurchaseMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return validatePurchaseMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseMoney();
        }
    }


    public WinningNumbers createWinningNums() {
        WinningNumbers winningNumbers = new WinningNumbers();
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNums = new ArrayList<>();
            validateInputWinningNums(winningNums);
            winningNumbers.setWinningNums(winningNums);

            createBonusNum(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNums();
        }
        return winningNumbers;
    }

    private void createBonusNum(WinningNumbers winningNumbers) {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonus = validateInputBonusNum(winningNumbers);
            winningNumbers.setBonusNum(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createBonusNum(winningNumbers);
        }
    }
}
