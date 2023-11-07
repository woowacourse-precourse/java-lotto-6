package lotto.controller;

import lotto.domain.Cash;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;

import lotto.dto.RequestCash;
import lotto.dto.RequestLottos;
import lotto.dto.RequestWinnerLotto;
import lotto.dto.RequestLottoResult;

import lotto.util.NumberGenerator;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final NumberGenerator numberGenerator;

    public GameController(NumberGenerator numberGeneratorImp) {
        this.numberGenerator = numberGeneratorImp;
    }

    public void play() {
        gameProcess();
    }


    private void gameProcess() {
        try {
            Cash cash = depositCash();
            Lottos lottos = purchaseLotto(cash);
            WinnerLotto winnerLotto = getWinnerLotto();
            compareLottosWithWinnerLotto(lottos, winnerLotto, cash);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        } catch (IllegalStateException e) {
            outputView.printErrorMessage(e);
        } finally {
            inputView.close();
        }
    }


    private Cash depositCash() throws IllegalStateException {
        try {
            RequestCash requestCash = inputView.requestCash();
            return Cash.create(requestCash.depositAmount(),
                               requestCash.spendAmount());
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return depositCash();
        }
        catch (IllegalStateException e) {
            throw e;
        }
    }

    private Lottos purchaseLotto(Cash cash) {
        LottoMachine lottoMachine = LottoMachine.create(numberGenerator, cash);
        RequestLottos requestLottos = lottoMachine.purchaseLottos();
        Lottos lottos = Lottos.create(requestLottos.createLottoDummy());
        outputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private WinnerLotto getWinnerLotto() throws IllegalStateException {
        try {
            List<Integer> winnerNumbers = getWinnerNumbers();
            Integer bonusNumber = getBonusNumber();
            RequestWinnerLotto requestWinnerLotto = RequestWinnerLotto.of(winnerNumbers, bonusNumber);
            return WinnerLotto.create(requestWinnerLotto.winnerNumbers(), requestWinnerLotto.bonusNumber());
        } catch (IllegalStateException e) {
            throw e;
        }
    }



    private List<Integer> getWinnerNumbers() throws IllegalStateException {
        try {
            List<Integer> winnerNumbers = inputView.requestWinnerNumbers();
            return winnerNumbers;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWinnerNumbers();
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    private Integer getBonusNumber() throws IllegalStateException {
        try {
            Integer bonusNumber = inputView.requestBonusNumber();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getBonusNumber();
        } catch (IllegalStateException e) {
            throw e;
        }
    }



    private void compareLottosWithWinnerLotto(Lottos lottos, WinnerLotto winnerLotto, Cash cash) {
        RequestLottoResult requestLottoResult = lottos.compareWithWinnerLotto(winnerLotto);
        LottoResult lottoResult = LottoResult.create(requestLottoResult.results());
        lottoResult.getRoundedTotalBenefit(cash.getDepositAmount());
        outputView.printStaticResult(lottoResult, cash);
    }

}






