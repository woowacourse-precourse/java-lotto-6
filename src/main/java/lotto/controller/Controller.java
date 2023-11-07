package lotto.controller;

import java.util.Map;
import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.ResultMaker;
import lotto.domain.SelectedBonus;
import lotto.domain.SelectedLotto;
import lotto.domain.SelectedNumbers;
import lotto.util.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoValidator validator = new LottoValidator();
    private LottoBundle lottoBundle;
    private ResultMaker resultMaker;

    public void run() {
        buyLotto();
        showYourLotto();
        checkLotto();
        showYourResult();
        showYourRateOfReturn();
    }

    private void buyLotto() {
        while (true) {
            try {
                LottoMachine lottoMachine = new LottoMachine(inputView.readMoney());
                lottoBundle = lottoMachine.makeLottoBundle();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showYourLotto() {
        outputView.printLottos(lottoBundle.getBundle());
    }

    private void checkLotto() {
        resultMaker = new ResultMaker(lottoBundle, selectWinningLotto());
        resultMaker.updateResult();
    }

    private void showYourResult() {
        Map<Rank, Integer> lottoResult = resultMaker.giveResult();
        outputView.printResult(lottoResult);
    }

    private void showYourRateOfReturn() {
        String rateOfReturn = resultMaker.calculateRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }

    private SelectedLotto selectWinningLotto() {
        SelectedNumbers nums = selectNumbers();
        SelectedBonus bonus = selectBonus(nums);
        return new SelectedLotto(nums, bonus);
    }

    private SelectedNumbers selectNumbers() {
        while (true) {
            try {
                return new SelectedNumbers(inputView.readSelectedNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private SelectedBonus selectBonus(SelectedNumbers selectedNumbers) {
        while (true) {
            try {
                return new SelectedBonus(inputView.readSelectedBonus(),
                        selectedNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
