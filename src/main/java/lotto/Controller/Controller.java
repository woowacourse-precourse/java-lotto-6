package lotto.Controller;

import java.util.List;
import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Domain.Rank;
import lotto.Service.LottoService;
import lotto.Util.InputResolver;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public Controller(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        purchaseLottoProcess();
        createWinningLottoProcess();
        showWinningResultProcess();
    }

    private void purchaseLottoProcess() {
        try {
            String inputMoney = inputView.receiveBuyPrice();
            outputView.showNewLine();

            int money = InputResolver.toInteger(inputMoney);
            List<Lotto> purchaseLotto = lottoService.purchaseLotto(money);
            outputView.showBuyLotto(purchaseLotto);
            outputView.showNewLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLottoProcess();
        }
    }
    private void createWinningLottoProcess() {
        try {
            List<Integer> winningNumbers = createWinningNumbersProcess();
            int bonusNumber = createBonusNumberProcess();
            lottoService.createWinningLotto(winningNumbers,bonusNumber);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createWinningLottoProcess();
        }
    }
    private List<Integer> createWinningNumbersProcess() {
        List<Integer> winningNumbers;
        try {
            String[] inputWinningNumbers = inputView.receiveWinningNumber();
            outputView.showNewLine();
            winningNumbers = InputResolver.toIntegerList(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumbers = createWinningNumbersProcess();
        }
        return winningNumbers;
    }
    private int createBonusNumberProcess() {
        int bonusNumber;
        try {
            String inputBonusNum = inputView.receiveBonusNumber();
            outputView.showNewLine();
            bonusNumber = InputResolver.toInteger(inputBonusNum);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = createBonusNumberProcess();
        }
        return bonusNumber;
    }
    public void showWinningResultProcess() {
        Map<Rank, Integer> winningResult = lottoService.createResult();
        double revenue = lottoService.getRevenue(winningResult);
        outputView.showWinningResult(winningResult);
        outputView.showRevenue(revenue);
    }
}
