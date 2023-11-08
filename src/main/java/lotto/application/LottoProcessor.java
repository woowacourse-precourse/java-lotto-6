package lotto.application;

import lotto.domain.BonusNumber;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoProvider;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLottoHolder;
import lotto.io.InputProcessor;
import lotto.io.OutputProcessor;

import java.util.List;

public class LottoProcessor {
    private final LottoGenerator lottoGenerator;

    private Buyer buyer;
    private WinningLottoHolder winningLottoHolder;

    public LottoProcessor(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        buyLotto();
        initLottoWinningMachine();
        notifyLottoResult();
    }

    private void buyLotto() {
        while (true) {
            try {
                final int lottoPurchaseCount = InputProcessor.readLottoPurchaseCount();
                final List<Lotto> lottos = LottoProvider.provideByPurchaseQuantity(lottoGenerator, lottoPurchaseCount);

                buyer = Buyer.provideLottos(lottos);
                OutputProcessor.printPurchaseInformation(buyer.getLottos());
                break;
            } catch (final IllegalArgumentException e) {
                OutputProcessor.printErrorMessage(e.getMessage());
            }
        }
    }

    private void initLottoWinningMachine() {
        final Lotto winningLotto = readWinningNumbers();
        readBonusNumber(winningLotto);
    }

    private Lotto readWinningNumbers() {
        while (true) {
            try {
                final List<Integer> winingNumbers = InputProcessor.readWiningNumbers();
                return Lotto.create(winingNumbers);
            } catch (final IllegalArgumentException e) {
                OutputProcessor.printErrorMessage(e.getMessage());
            }
        }
    }

    private void readBonusNumber(final Lotto winningLotto) {
        while (true) {
            try {
                final BonusNumber bonusNumber = BonusNumber.create(InputProcessor.readBonusNumber());
                winningLottoHolder = WinningLottoHolder.drawWinningLotto(winningLotto, bonusNumber);
                break;
            } catch (final IllegalArgumentException e) {
                OutputProcessor.printErrorMessage(e.getMessage());
            }
        }
    }

    private void notifyLottoResult() {
        final LottoStatistics lottoStatistics = LottoStatistics.checkLottoResult(winningLottoHolder, buyer);
        OutputProcessor.printWinningStatistics(lottoStatistics);
    }
}
