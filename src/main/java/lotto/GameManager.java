package lotto;

import java.util.List;
import lotto.dto.LottoBundleDto;
import lotto.dto.LottoResult;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoMachine lottoMachine = configure();
        play(lottoMachine);
    }

    private LottoMachine configure() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoPublisher lottoPublisher = new LottoPublisher(numberGenerator);
        LottoSeller lottoSeller = new LottoSeller(lottoPublisher);
        LottoJudge lottoJudge = new LottoJudge();

        return new LottoMachine(lottoSeller, lottoJudge);
    }

    private void play(LottoMachine lottoMachine) {
        outputView.printPaymentRequest();
        LottoBundle bundle = buyLottoBundle(lottoMachine);
        outputView.printLottoBundle(LottoBundleDto.from(bundle));

        outputView.printWinningLottoNumbersRequest();
        List<Integer> numbers = inputView.enterWinningLottoNumbers();
        outputView.printWinningLottoBonusNumberRequest();
        int bonusNumber = inputView.enterBonusNumber();
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);
        lottoMachine.configureJudge(winningLotto);

        LottoResult result = lottoMachine.judge(bundle);
        outputView.printResult(result);
    }

    private LottoBundle buyLottoBundle(LottoMachine lottoMachine) {
        while (true) {
            try {
                Money money = inputView.payMoney();
                return lottoMachine.buyLotto(money);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
