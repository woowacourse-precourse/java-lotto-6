package lotto.controller;

import lotto.model.*;
import lotto.util.NumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        LottoMoney lottoMoney = inputLottoMoney();
        List<Lotto> lottos = purchaseLottos(lottoMoney);
        LottoStorage lottoStore = LottoStorage.from(lottos);
        outputView.outputPurchaseResult(lottoStore, lottoMoney.availableLottoCount());

        Lotto winningNumber = inputWinningNumber();
        Integer bonusNumber = inputBonusNumber();

        WinningNumbers winningNumbers = winningNumbers(winningNumber, bonusNumber);

        LottoResult lottoResult = LottoResult.of(lottoStore, winningNumbers);
        outputView.outputLottoResult(lottoResult, lottoMoney.getMoney());
    }

    private WinningNumbers winningNumbers(Lotto winningNumber, Integer bonusNumber) {
        try {
            return WinningNumbers.of(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningNumbers(winningNumber, inputBonusNumber());
        }
    }

    private Lotto inputWinningNumber() {
        try {
            return Lotto.from(inputView.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    private Integer inputBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static List<Lotto> purchaseLottos(LottoMoney lottoMoney) {
        try {
            return addLottoByMoney(lottoMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottos(lottoMoney);
        }
    }

    private static List<Lotto> addLottoByMoney(LottoMoney lottoMoney) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoMoney.availableLottoCount(); i++) {
            lottos.add(Lotto.from(NumbersGenerator.lottoNumbersGenerator()));
        }
        return lottos;
    }

    private LottoMoney inputLottoMoney() {
        try {
            return new LottoMoney(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoMoney();
        }
    }

}
