package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.validation.InputValidator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LottoController {
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private Amount amount;
    private Buyer buyer;
    private WinningLotto winningLotto;

    public void play() {
        buyLotto();
        winningLottoSetting();
        resultLotto();
    }

    private void buyLotto() {
        settingAmount();
        this.buyer = new Buyer(getBuyerLottos());
        OutputView.purchaseLottos(buyer);
    }

    private Lottos getBuyerLottos() {
        return new Lottos(IntStream
                .range(0, this.amount.buyCount())
                .mapToObj(i -> new Lotto(lottoNumberGenerator.pickUniqueNumbers()))
                .toList()
        );
    }

    private void settingAmount() {
        while (true) {
            try {
                this.amount = new Amount(getPurchaseAmount());
                return;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private double getPurchaseAmount() {
        String inputAmount = InputView.getPurchaseAmountFromInput();
        InputValidator.validatePurchase(inputAmount);
        return Double.parseDouble(inputAmount);
    }

    private void winningLottoSetting() {
        Lotto winningNumberLotto = getWinningLottoAndCheck();
        BonusNumber bonusNumber = getBonusNumberAndCheck(winningNumberLotto);
        this.winningLotto = new WinningLotto(winningNumberLotto, bonusNumber);
    }

    private Lotto getWinningLottoAndCheck() {
        while (true) {
            try {
                String inputWinningLotto = InputView.getWinningLottoFromInput();
                InputValidator.validateBlank(inputWinningLotto);
                return new Lotto(
                        Arrays.stream(inputWinningLotto.split(",", -1))
                                .map(InputValidator::validateLottoNumberAndConvertToNumeric)
                                .toList()
                );
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private BonusNumber getBonusNumberAndCheck(Lotto winningNumberLotto) {
        while (true) {
            try {
                String inputBonusNumber = InputView.getBonusNumberFromInput();
                InputValidator.validateBonusNumber(inputBonusNumber);
                BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(inputBonusNumber.trim()));
                bonusNumber.containsException(winningNumberLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private void resultLotto() {
        OutputView.winningResult(new Result(buyer.confirmLotto(winningLotto)));
    }
}
