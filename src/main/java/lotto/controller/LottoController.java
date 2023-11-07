package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoAnalyzeService;
import lotto.service.dto.LottosDTO;
import lotto.service.dto.ResultDTO;
import lotto.service.LottoIssueService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoIssueService lottoIssueService = new LottoIssueService();
    LottoAnalyzeService lottoAnalyzeService = new LottoAnalyzeService();
    public void run() {
        Money money = receiveUserMoney();
        LottosDTO lottosDTO = lottoIssueService.sendBoughtLotto(money);
        outputView.printBoughtLottos(lottosDTO.getTotalLottoBought(), lottosDTO.getLottos());

        WinningLotto winningLotto = receiveUserBonusNumber(receiveUserStandardNumber());
        ResultDTO resultDTO = lottoAnalyzeService.sendAnalyzedData(lottosDTOtoLottos(lottosDTO), winningLotto, money);
        outputView.printResult(resultDTO);
    }

    private Money receiveUserMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserMoney();
    }

    private Lotto receiveUserStandardNumber() {
        try {
            return new Lotto(inputView.inputWinningLottoStandardNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserStandardNumber();
    }

    private WinningLotto receiveUserBonusNumber(Lotto lotto) {
        try {
            return new WinningLotto(lotto, inputView.inputWinningLottoBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return receiveUserBonusNumber(lotto);
    }

    private Lottos lottosDTOtoLottos(LottosDTO lottosDTO) {
        return new Lottos(lottosDTO.getLottos().stream()
                .map(Lotto::new)
                .toList());
    }
}
