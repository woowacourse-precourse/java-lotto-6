package lotto.handler;

import lotto.domain.LottoRankings;
import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.dto.LottoDto;
import lotto.manager.LottoManager;
import lotto.view.LottoReadMessage;
import lotto.view.LottoReader;
import lotto.view.LottoWriteParser;
import lotto.view.LottoWriter;

import java.util.List;


public class LottoHandler {

    private final LottoManager lottoManager;
    private final LottoReader reader;
    private final LottoWriter writer;
    private final LottoWriteParser lottoWriteParser;

    public LottoHandler(
            LottoManager lottoManager, LottoReader reader, LottoWriter writer, LottoWriteParser lottoWriteParser
    ) {
        this.lottoManager = lottoManager;
        this.reader = reader;
        this.writer = writer;
        this.lottoWriteParser = lottoWriteParser;
    }

    public void run() {
        Payment payment = getPayment();
        Lottos lottos = lottoManager.createLottos(payment);

        showPaidLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        LottoRankings winningRankings = lottoManager.calculateWinningRankings(lottos, winningNumbers, bonusNumber);
        double profitPercentage = lottoManager.calculateProfitPercentage(payment, winningRankings);

        showResult(winningRankings, profitPercentage);
    }

    private void showPaidLottos(Lottos lottos) {
        writer.write(lottoWriteParser.parsePaidLottoLog(lottos.size()));
        writer.write(lottoWriteParser.parseLottosDetail(LottoDto.Information.from(lottos)));
    }

    private void showResult(LottoRankings winningRankings, double profitPercentage) {
        writer.write(lottoWriteParser.parseLottoResult(LottoDto.Result.from(winningRankings)));
        writer.write(lottoWriteParser.parseProfit(profitPercentage));
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        writer.write(LottoReadMessage.INPUT_BONUS_NUMBER.getMessage());
        return reader.readBonusNumber(winningNumbers);
    }

    private List<Integer> getWinningNumbers() {
        writer.write(LottoReadMessage.INPUT_WINNING_NUMBERS.getMessage());
        return reader.readWinningNumbers();
    }

    private Payment getPayment() {
        writer.write(LottoReadMessage.INPUT_MONEY.getMessage());
        return reader.readPayment();
    }
}
