package lotto.view;

import lotto.dto.input.BonusNumberDto;
import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningNumbersDto;
import lotto.io.input.StdReader;
import lotto.io.output.StdWriter;

public class InputView {
    private final StdReader reader;
    private final StdWriter writer;

    public InputView(StdReader reader, StdWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public MoneyDto inputMoney() {
        writer.writeLine("구입금액을 입력해 주세요.");
        String input = reader.readLine();
        InputValidator.verifyNonEmptyInput(input);
        InputValidator.verifyNumericString(input);
        return MoneyDto.from(input);
    }

    public WinningNumbersDto inputWinningNumbers() {
        writer.writeLine("당첨 번호를 입력해 주세요.");
        String input = reader.readLine();
        InputValidator.verifyNonEmptyInput(input);
        InputValidator.verifyValidaNumberFormat(input);
        return WinningNumbersDto.from(input);
    }

    public BonusNumberDto inputBonusNumber() {
        writer.writeLine("보너스 번호를 입력해 주세요.");
        String input = reader.readLine();
        InputValidator.verifyNonEmptyInput(input);
        InputValidator.verifyNumericString(input);
        return BonusNumberDto.from(input);
    }
}
