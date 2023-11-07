package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.exception.Validator;
import lotto.util.Parser;

import java.util.List;

public class InputView {
    public static int readPurChaseLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            String amount = Console.readLine();
            Validator.validatePurChaseAmount(amount);
            System.out.println();
            return Integer.parseInt(amount) / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurChaseLottoAmount();
        }
    }

    public static Lotto readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNum = Console.readLine();

        try {
            Validator.validateWinningNumber(winningNum);
            System.out.println();
            return new Lotto(Parser.parseWinningNumber(winningNum, ","));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumber();
        }
    }

    public static WinningLotto readWinningLotto() {
        Lotto winningNumbers = readWinningNumber();
        int bonusNumber = readBonusNumber(winningNumbers);

        try {
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            return readWinningLotto();
        }
    }

    public static int readBonusNumber(Lotto winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        try {
            Validator.validateBonusNumber(bonusNumber, winningNumbers.getNumbers());
            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winningNumbers);
        }
    }
}
