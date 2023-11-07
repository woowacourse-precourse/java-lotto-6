package lotto.domain.contoller;

import java.util.List;
import lotto.domain.repository.Lotto;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.service.LottoBonusService;
import lotto.service.LottoInputDrawNumberService;
import lotto.service.LottoNumberCompareService;
import lotto.service.LottoPublishService;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    LottoPublishService lottoPublishService = LottoPublishService.getInstance();
    LottoInputDrawNumberService lottoInputDrawNumberService = LottoInputDrawNumberService.getInstance();
    LottoBonusService lottoBonusService = LottoBonusService.getInstance();

    private LottoNumberCompareService lottoNumberCompareService = LottoNumberCompareService.getInstance();

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        this.buyLotto();
        this.lottoPublish();
        this.saveDrawNumbers();
        this.saveBonusNumbers();
        this.processDrawResult();
        this.printResult();
    }

    private void printResult() {
        outputView.printResultMessage();
        outputView.printRewardResult(lottoNumberCompareService.getMatchResult());
        outputView.printEarnings(lottoNumberCompareService.getEarnings());
    }

    private void processDrawResult() {
        lottoNumberCompareService.inputNumber(lottoPublishService.getPublishedLottoNumbers(),
                lottoInputDrawNumberService.getLottoDrawNumber(), lottoBonusService.getLottoBonusNumber(),
                lottoPublishService.getLottoPrice());

        lottoNumberCompareService.initMatchResult();
        lottoNumberCompareService.calcResult();
    }

    private void saveBonusNumbers() {
        try {
            lottoBonusService.setLottoBonusNumber(inputView.requestInputBonusNumbers(),
                    lottoInputDrawNumberService.getLottoDrawNumber());
        } catch (IllegalArgumentException e) {
            inputView.printMessage(e.getMessage());
            this.saveBonusNumbers();
        }
    }

    private void saveDrawNumbers() {
        try {
            lottoInputDrawNumberService.saveDrawNumber(inputView.requestInputDrawNumbers());
        } catch (IllegalArgumentException e) {
            inputView.printMessage(e.getMessage());
            this.saveDrawNumbers();
        }
    }

    private void buyLotto() {
        this.requestInputPrice();
    }

    private void requestInputPrice() {
        try {
            lottoPublishService.lottoPublish(inputView.requestInputPrice());
        } catch (IllegalArgumentException e) {
            inputView.printMessage(e.getMessage());
            this.requestInputPrice();
        }
    }

    private void lottoPublish() {
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        outputView.printPublishCount(lottos.size());
        outputView.printPublishedLottoNumbers(lottoPublishService.getPublishedLottoNumbers());
    }
}
