package lotto.view;

import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningCombinationDto;
import lotto.dto.input.builder.WinningCombinationBuilder;
import lotto.io.input.StdReader;
import lotto.io.output.StdWriter;
import lotto.util.ViewConstants;
import lotto.validator.InputValidator;

public class InputView {
    private final StdReader reader;
    private final StdWriter writer;

    public InputView(StdReader reader, StdWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public MoneyDto inputMoney() {
        writer.writeLine(ViewConstants.INPUT_MONEY_MESSAGE);
        try {
            String input = reader.readLine();
            InputValidator.verifyNonEmptyInput(input);
            InputValidator.verifyValidaNumberFormat(input);
            return MoneyDto.from(input);
        } catch (IllegalArgumentException e) {
            writer.writeLine(e.getMessage());
            return inputMoney();
        }
    }

    public WinningCombinationDto inputWinningCombination() {
        WinningCombinationBuilder builder = WinningCombinationBuilder.builder();
        inputWinningNumbers(builder);
        inputBonusNumber(builder);
        return builder.build();
    }

    public WinningCombinationBuilder inputWinningNumbers(WinningCombinationBuilder builder) {
        writer.writeLine(ViewConstants.INPUT_WINNING_NUMBERS_MESSAGE);
        try {
            String input = reader.readLine();
            InputValidator.verifyNonEmptyInput(input);
            InputValidator.verifyValidaNumberFormat(input);
            builder.withWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            writer.writeLine(e.getMessage());
            return inputWinningNumbers(builder);
        }
        return builder;
    }

    public WinningCombinationBuilder inputBonusNumber(WinningCombinationBuilder builder) {
        writer.writeLine(ViewConstants.INPUT_BONUS_NUMBER_MESSAGE);
        try {
            String input = reader.readLine();
            InputValidator.verifyNonEmptyInput(input);
            InputValidator.verifyNumericString(input);
            builder.withBonusNumber(input);
        } catch (IllegalArgumentException e) {
            writer.writeLine(e.getMessage());
            return inputBonusNumber(builder);
        }
        return builder;
    }
}
