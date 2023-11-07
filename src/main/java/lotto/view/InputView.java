package lotto.view;

import lotto.domain.dto.input.PurchaseLottoDto;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.parser.Parser;

import java.util.List;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    private final Writer writer;
    private final Reader reader;

    public InputView(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public PurchaseLottoDto getPurchaseAmount() {
        writer.writeln(INPUT_PURCHASE_AMOUNT);
        try {
            int amount = Parser.parseStrToInt(reader.readLine());
            return new PurchaseLottoDto(amount);
        } catch (IllegalArgumentException e) {
            writer.writeln(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinningNumber() {
        writer.writeln(INPUT_WINNING_NUMBERS);
        try {
            String inputNumbers = reader.readLine();
            return Parser.parseWinningNumbers(inputNumbers);
        } catch (IllegalArgumentException e) {
            writer.writeln(e.getMessage());
            return getWinningNumber();
        }
    }

    public int getBonusNumber() {
        writer.writeln(INPUT_BONUS_NUMBERS);
        try {
            return Parser.parseStrToInt(reader.readLine());
        } catch (IllegalArgumentException e) {
            writer.writeln(e.getMessage());
            return getBonusNumber();
        }
    }
}
