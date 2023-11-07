package lotto.view;

import lotto.exception.Validator;
import lotto.domain.Lotto;
import lotto.domain.Parser;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int getPurchaseAmount() {
        String amount = "";
        try {
            System.out.println("구입금액을 입력해 주세요.");
            amount = readLine();
            Validator.validatePurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
        System.out.println();
        return Integer.parseInt(amount);
    }

    public Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = readLine();
        try {
            Validator.validateWinningNumbers(winningNumbersInput);
            List<Integer> winningNumbers = Parser.parseNumbers(winningNumbersInput);
            System.out.println();
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(Lotto winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        try {
            System.out.println();
            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}