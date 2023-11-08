package lotto.view;

import lotto.domain.dto.input.PurchaseLottoRequest;
import lotto.domain.dto.input.WinningLottoRequest;
import lotto.domain.dto.input.WinningLottoRequestBuilder;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.parser.Parser;

import java.util.List;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "\n보너스 번호를 입력해 주세요.";
    private final Writer writer;
    private final Reader reader;

    public InputView(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public PurchaseLottoRequest getPurchaseAmount() {
        writer.writeln(INPUT_PURCHASE_AMOUNT);
        try {
            int amount = Parser.parseStrToInt(reader.readLine());
            return new PurchaseLottoRequest(amount);
        } catch (IllegalArgumentException exception) {
            writer.writeln(exception.getMessage());
            return getPurchaseAmount();
        }
    }

    public WinningLottoRequest getWinningLottoNumbers() {
        WinningLottoRequestBuilder winningLottoBuilder = WinningLottoRequestBuilder.create();
        getWinningNumber(winningLottoBuilder);
        getBonusNumber(winningLottoBuilder);
        return winningLottoBuilder.build();
    }

    private WinningLottoRequestBuilder getWinningNumber(WinningLottoRequestBuilder winningLottoBuilder) {
        writer.writeln(INPUT_WINNING_NUMBERS);
        try {
            String inputNumbers = reader.readLine();
            List<Integer> winningNumbers = Parser.parseWinningNumbers(inputNumbers);
            return winningLottoBuilder.winningNumbers(winningNumbers);
        } catch (IllegalArgumentException exception) {
            writer.writeln(exception.getMessage());
            return getWinningNumber(winningLottoBuilder);
        }
    }

    private WinningLottoRequestBuilder getBonusNumber(WinningLottoRequestBuilder winningLottoBuilder) {
        writer.writeln(INPUT_BONUS_NUMBERS);
        try {
            int bonusNumber = Parser.parseStrToInt(reader.readLine());
            return winningLottoBuilder.bonusNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            writer.writeln(exception.getMessage());
            return getBonusNumber(winningLottoBuilder);
        }
    }
}
