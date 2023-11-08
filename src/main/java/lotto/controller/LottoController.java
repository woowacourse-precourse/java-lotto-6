package lotto.controller;

import lotto.model.domain.Lotto;
import lotto.model.domain.Referee;
import lotto.model.service.LottoService;
import lotto.model.service.RefereeService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public final InputView inputView = new InputView();
    public final OutputView outputView = new OutputView();
    public final LottoService lottoService = new LottoService();
    public final RefereeService refereeService = new RefereeService();

    public void playLotto() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        outputView.printLottoAmount(purchaseAmount);

        List<Lotto> lottoList = lottoService.initLottoList(purchaseAmount);
        outputView.printLottoNumbers(lottoList);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        Referee referee = new Referee(winningNumbers, bonusNumber);
        refereeService.calculateLottoResult(referee, lottoList);

        outputView.printLottoRankingResult(referee);
        outputView.printLottoBenefitResult(referee);
    }
}
