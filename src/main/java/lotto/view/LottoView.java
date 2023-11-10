package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.constants.LottoRank;
import lotto.controller.dto.input.BonusBallDto;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.input.WinningLottoNumbersDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.controller.dto.output.WinningLottoResultDto;
import lotto.io.reader.Reader;
import lotto.io.writer.Writer;
import lotto.model.lotto.Lotto;
import lotto.view.constants.LottoRankMessage;
import lotto.view.constants.Message;
import lotto.view.constants.MessageFormatter;

public class LottoView {
    private final Reader reader;
    private final Writer writer;

    public LottoView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public LottoPurchaseAmountDto inputLottoPurchaseAmount() {
        writer.writeLine(Message.INPUT_LOTTO_PURCHASE_AMOUNT.getValue());
        return new LottoPurchaseAmountDto(reader.readLine());
    }

    public void showPurchasedLottos(PurchasedLottosDto purchasedLottosDto) {
        List<Lotto> lottos = purchasedLottosDto.purchasedLottos();

        String purchasedLottoNumbersMessage = getPurchasedLottoNumbersMessage(lottos);

        String purchasedLottos = String.join(MessageFormatter.LINE_SEPARATOR.value,
                Message.PURCHASED_LOTTOS_COUNT.getValue(lottos.size()),
                purchasedLottoNumbersMessage);
        writer.writeLine(MessageFormatter.LINE_SEPARATOR.value + purchasedLottos);
    }

    private String getPurchasedLottoNumbersMessage(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers().toArray())
                .map(Message.PURCHASED_LOTTO_NUMBERS::getValue)
                .collect(Collectors.joining(MessageFormatter.LINE_SEPARATOR.value));
    }

    public WinningLottoNumbersDto inputWinningLottoNumbers() {
        writer.writeLine(MessageFormatter.LINE_SEPARATOR.value + Message.INPUT_WINNING_LOTTO_NUMBERS.getValue());
        return new WinningLottoNumbersDto(reader.readLine());
    }

    public BonusBallDto inputBonusBallNumber() {
        writer.writeLine(MessageFormatter.LINE_SEPARATOR.value + Message.INPUT_BONUS_BALL_NUMBER.getValue());
        return new BonusBallDto(reader.readLine());
    }

    public void showWinningLottoResult(WinningLottoResultDto winningLottoResultDto) {
        String winningLottoCountByRankMessage = getWinningLottoCountByRankMessage(
                winningLottoResultDto.winningResult());

        String winningLottoResultMessage = String.join(MessageFormatter.LINE_SEPARATOR.value,
                Message.WINNING_STATISTICS_HEADER.getValue(),
                Message.WINNING_STATISTICS_DIVIDER.getValue(),
                winningLottoCountByRankMessage,
                Message.PROFIT_RATE.getValue(winningLottoResultDto.profitRate()));
        writer.writeLine(MessageFormatter.LINE_SEPARATOR.value + winningLottoResultMessage);
    }

    private String getWinningLottoCountByRankMessage(List<LottoRank> winningResult) {
        return Arrays.stream(LottoRankMessage.values())
                .map(lottoRankMessage -> {
                    LottoRank rank = lottoRankMessage.getRank();
                    int lottoCountByRank = (int) winningResult.stream()
                            .filter(rank::equals)
                            .count();
                    return Message.WINNING_LOTTOS_COUNT_PER_PRIZE.getValue(
                            lottoRankMessage.getMessage(), lottoCountByRank);
                })
                .collect(Collectors.joining(MessageFormatter.LINE_SEPARATOR.value));
    }

    public void showError(String message) {
        writer.writeLine(MessageFormatter.ERROR_MESSAGE_PREFIX.value + message);
    }

    public void release() {
        reader.close();
    }
}
