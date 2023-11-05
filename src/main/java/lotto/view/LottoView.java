package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.controller.dto.input.BonusBallDto;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.input.WinningLottoNumbersDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.io.reader.Reader;
import lotto.io.writer.Writer;
import lotto.view.constants.LottoMessage;

public class LottoView {

    private final Reader reader;
    private final Writer writer;

    public LottoView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public LottoPurchaseAmountDto inputLottoPurchaseAmount() {
        writer.writeLine(LottoMessage.INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
        return new LottoPurchaseAmountDto(reader.readLine());
    }

    public void showPurchasedLottos(PurchasedLottosDto purchasedLottosDto) {
        List<Lotto> lottos = purchasedLottosDto.purchasedLottos();
        int purchasedLottosCount = lottos.size();

        writer.writeLine(LottoMessage.PURCHASED_LOTTOS_COUNT.getMessage(purchasedLottosCount));
        String lineSeparator = System.lineSeparator();
        String purchasedLottoNumbers = lottos.stream()
                .map(lotto -> lotto.getNumbers().toArray())
                .map(LottoMessage.LOTTO_NUMBERS::getMessage)
                .collect(Collectors.joining(lineSeparator));
        writer.writeLine(purchasedLottoNumbers + lineSeparator);
    }

    public WinningLottoNumbersDto inputWinningLottoNumbers() {
        writer.writeLine(LottoMessage.INPUT_WINNING_LOTTO_NUMBERS.getMessage());
        return new WinningLottoNumbersDto(reader.readLine());
    }

    public BonusBallDto inputBonusBallNumber() {
        writer.writeLine(LottoMessage.INPUT_BONUS_BALL_NUMBER.getMessage());
        return new BonusBallDto(reader.readLine());
    }
}
