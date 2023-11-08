package lotto.view;

import lotto.controller.dto.GameResult;
import lotto.controller.dto.LottoResult;
import lotto.view.vo.Validator;
import lotto.view.vo.WinningNumbers;

import java.text.MessageFormat;
import java.util.List;

public class Console {

    private WinningNumbers winningNumbers;

    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int readMoney() {
        output.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return validatedMoney();
            } catch (IllegalArgumentException e) {
                output.println(e.getMessage());
            }
        }
    }

    private int validatedMoney() {
        String value = input.read();
        Validator.validateMoney(value);
        return Integer.parseInt(value);
    }

    public List<Integer> readWinningNumbers() {
        output.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                return validatedWinningNumbers();
            } catch (IllegalArgumentException e) {
                output.println(e.getMessage());
            }
        }

    }

    private List<Integer> validatedWinningNumbers() {
        String value = input.read();
        this.winningNumbers = Validator.validateWinningNumbers(value);

        return winningNumbers.numbers();
    }

    public int readBonusNumber() {
        output.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                return validatedBonusNumber();
            } catch (IllegalArgumentException e) {
                output.println(e.getMessage());
            }
        }
    }

    private int validatedBonusNumber() {
        String value = input.read();
        Validator.validateBonusNumber(value, winningNumbers);
        return Integer.parseInt(value);
    }

    public void printLottoResults(GameResult gameResult) {
        ResultPrinter.print(gameResult);
    }

    public void printLottoCount(int lottoCount) {
        String lottoCountMessage = MessageFormat.format("\n{0}개를 구매했습니다.", lottoCount);
        output.println(lottoCountMessage);
    }

    public void printLottos(LottoResult result) {
        ResultPrinter.print(result);
    }

}
