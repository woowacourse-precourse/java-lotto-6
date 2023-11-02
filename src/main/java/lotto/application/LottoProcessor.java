package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoProvider;
import lotto.domain.LottoStatistics;
import lotto.domain.User;
import lotto.domain.WinningLottoHolder;
import lotto.io.InputProcessor;
import lotto.io.OutputProcessor;

import java.util.List;

public class LottoProcessor {
    private static User user;
    private static WinningLottoHolder winningLottoHolder;

    private final LottoGenerator lottoGenerator;

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

                user = User.provideLottos(lottos);
                OutputProcessor.printPurchaseInformation(user.getLottos());
                break;
            } catch (final IllegalArgumentException e) {
                OutputProcessor.printErrorMessage(e.getMessage());
            }
        }
    }

    private void initLottoWinningMachine() {
        while (true) {
            try {
                final List<Integer> winingNumbers = InputProcessor.readWiningNumbers();
                final int bonusNumber = InputProcessor.readBonusNumber();

                winningLottoHolder = WinningLottoHolder.drawWinningLotto(winingNumbers, bonusNumber);
                break;
            } catch (final IllegalArgumentException e) {
                OutputProcessor.printErrorMessage(e.getMessage());
            }
        }
    }

    private void notifyLottoResult() {
        final LottoStatistics lottoStatistics = LottoStatistics.checkLottoResult(winningLottoHolder, user);
        OutputProcessor.printWinningStatistics(lottoStatistics);
    }
}
