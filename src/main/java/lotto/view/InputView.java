package lotto.view;

import lotto.domain.dto.input.PurchaseLottoDto;
import lotto.domain.dto.input.WinningLottoNumbersDto;
import lotto.domain.dto.input.WinningLottoNumbersDtoBuilder;
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

    public WinningLottoNumbersDto getWinningLottoNumbers() {
        WinningLottoNumbersDtoBuilder numbersDtoBuilder = WinningLottoNumbersDtoBuilder.create();
        getWinningNumber(numbersDtoBuilder);
        getBonusNumber(numbersDtoBuilder);
        return numbersDtoBuilder.build();
    }

    private WinningLottoNumbersDtoBuilder getWinningNumber(WinningLottoNumbersDtoBuilder numbersDtoBuilder) {
        writer.writeln(INPUT_WINNING_NUMBERS);
        try {
            String inputNumbers = reader.readLine();
            List<Integer> winningNumbers = Parser.parseWinningNumbers(inputNumbers);
            return numbersDtoBuilder.winningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            writer.writeln(e.getMessage());
            return getWinningNumber(numbersDtoBuilder);
        }
    }

    private WinningLottoNumbersDtoBuilder getBonusNumber(WinningLottoNumbersDtoBuilder numbersDtoBuilder) {
        writer.writeln(INPUT_BONUS_NUMBERS);
        try {
            int bonusNumber = Parser.parseStrToInt(reader.readLine());
            return numbersDtoBuilder.bonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            writer.writeln(e.getMessage());
            return getBonusNumber(numbersDtoBuilder);
        }
    }
}
