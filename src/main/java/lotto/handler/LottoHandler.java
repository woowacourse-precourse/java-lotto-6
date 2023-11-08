package lotto.handler;

import lotto.domain.LottoRankings;
import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.dto.LottoDto;
import lotto.manager.LottoManager;
import lotto.view.LottoGuideMessage;
import lotto.view.LottoReader;
import lotto.view.LottoViewResolver;
import lotto.view.LottoWriter;

import java.util.List;


public class LottoHandler {

    private final LottoManager lottoManager;
    private final LottoReader reader;
    private final LottoWriter writer;
    private final LottoViewResolver lottoViewResolver;

    public LottoHandler(LottoManager lottoManager, LottoReader reader, LottoWriter writer, LottoViewResolver lottoViewResolver) {
        this.lottoManager = lottoManager;
        this.reader = reader;
        this.writer = writer;
        this.lottoViewResolver = lottoViewResolver;
    }

    public void run() {
        Payment payment = getPayment();
        Lottos lottos = lottoManager.createLottos(payment);

        showPaidLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        WinningLotto winningLotto = lottoManager.createWinningLotto(winningNumbers, bonusNumber);
        LottoRankings winningRankings = lottoManager.createWinningRankings(lottos, winningLotto);
        double profitPercentage = lottoManager.calculateProfitPercentage(payment, winningRankings);

        showResult(winningRankings, profitPercentage);
    }

    private void showPaidLottos(Lottos lottos) {
        writer.write(lottoViewResolver.parsePaidLottoLog(lottos.size()));
        writer.write(lottoViewResolver.parseLottosDetail(LottoDto.Information.from(lottos)));
    }

    private void showResult(LottoRankings winningRankings, double profitPercentage) {
        writer.write(lottoViewResolver.parseLottoResult(LottoDto.Result.from(winningRankings)));
        writer.write(lottoViewResolver.parseProfit(profitPercentage));
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        writer.write(LottoGuideMessage.INPUT_BONUS_NUMBER.getMessage());
        return reader.readBonusNumber(winningNumbers);
    }

    private List<Integer> getWinningNumbers() {
        writer.write(LottoGuideMessage.INPUT_WINNING_NUMBERS.getMessage());
        return reader.readWinningNumbers();
    }

    private Payment getPayment() {
        writer.write(LottoGuideMessage.INPUT_MONEY.getMessage());
        return reader.readPayment();
    }
}
