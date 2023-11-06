package lotto.view;

import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningCombinationDto;
import lotto.dto.input.builder.WinningCombinationBuilder;
import lotto.io.input.StdReader;
import lotto.io.output.StdWriter;
import lotto.io.output.Writer;

public class InputView {
    private final StdReader reader;
    private final StdWriter writer;

    public InputView(StdReader reader, StdWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public MoneyDto inputMoney() {
        writer.writeLine("구입금액을 입력해 주세요.");
        try {
            String input = reader.readLine();
            InputValidator.verifyNonEmptyInput(input);
            InputValidator.verifyValidaNumberFormat(input);
            return MoneyDto.from(input);
        } catch (IllegalArgumentException e) {
            writer.writeLine(Writer.ERROR_PREFIX + e.getMessage());
            return inputMoney();
        }
    }

    public WinningCombinationDto inputWinningCombination() {
        try {
            WinningCombinationBuilder builder = WinningCombinationBuilder.builder();
            inputWinningNumbers(builder);
            inputBonusNumber(builder);
            return builder.build();
        } catch (IllegalArgumentException e) {
            writer.writeLine(Writer.ERROR_PREFIX + e.getMessage());
            return inputWinningCombination();
        }
    }

    public WinningCombinationBuilder inputWinningNumbers(WinningCombinationBuilder builder) {
        writer.writeLine("당첨 번호를 입력해 주세요.");
        try {
            String input = reader.readLine();
            InputValidator.verifyNonEmptyInput(input);
            InputValidator.verifyValidaNumberFormat(input);
            builder.withWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            writer.writeLine(Writer.ERROR_PREFIX + e.getMessage());
            return inputWinningNumbers(builder);
        }
        return builder;
    }

    public WinningCombinationBuilder inputBonusNumber(WinningCombinationBuilder builder) {
        writer.writeLine(Writer.NEW_LINE + "보너스 번호를 입력해 주세요.");
        try {
            String input = reader.readLine();
            InputValidator.verifyNonEmptyInput(input);
            InputValidator.verifyNumericString(input);
            builder.withBonusNumber(input);
        } catch (IllegalArgumentException e) {
            writer.writeLine(Writer.ERROR_PREFIX + e.getMessage());
            return inputBonusNumber(builder);
        }
        return builder;
    }
}
