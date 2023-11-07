package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.exception.Validator;
import lotto.util.Parser;

import java.util.List;

public class InputView {
    public static int readPurChaseLottoAmount() {
        String amount = "";
        try {
            System.out.println("구입금액을 입력해 주세요.");
            amount = Console.readLine();
            Validator.validatePurChaseAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurChaseLottoAmount();
        }
        System.out.println();
        return Integer.parseInt(amount) / 1000;
    }

    public static List<Integer> readWinningNumber() {
        String winningNum = "";
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            winningNum = Console.readLine();
            Validator.validateWinningNumber(winningNum);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumber();
        }
        return Parser.parseWinningNumber(winningNum, ",");
    }

    public static WinningLotto readWinningLotto() {
        List<Integer> winningNumbers = readWinningNumber();

        return new WinningLotto(winningNumbers, readBonusNumber(winningNumbers));
    }

    public static int readBonusNumber(List<Integer> winningNumbers) {
        String bonusNumber = "";
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Console.readLine();
            Validator.validateBonusNumber(bonusNumber, winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningNumbers);
        }
        return Integer.parseInt(bonusNumber);
    }
}
