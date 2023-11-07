package lotto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.result.LottoResults;
import lotto.domain.vo.Bonus;
import lotto.service.LottoService;
import lotto.view.Communicator;

public class LottoController {
    private final Communicator communicator;
    private final LottoService lottoService;

    public LottoController(Communicator communicator, LottoService lottoService) {
        this.communicator = communicator;
        this.lottoService = lottoService;
    }

    public void run() {
        BigDecimal payment = settlePayment();
        buyLotteries(payment);
        confirmJackpotLotto();
        finishUp(payment);
    }

    private void buyLotteries(BigDecimal payment) {
        List<Lotto> lotteries = lottoService.generateLotteries(payment);
        communicator.printLotteriesBought(lotteries);
    }

    private void finishUp(BigDecimal payment) {
        LottoResults results = lottoService.matchLotteries();
        communicator.printResults(payment, results);
    }

    private void confirmJackpotLotto() {
        List<Integer> jackpotNumbers = confirmJackpotNumbers();
        confirmBonusAndSave(jackpotNumbers);
    }

    private BigDecimal settlePayment() {
        BigDecimal payment = BigDecimal.ZERO;
        while (payment.equals(BigDecimal.ZERO)) {
            payment = receivePayment();
        }
        return payment;
    }

    private BigDecimal receivePayment() {
        try {
            return communicator.instructBuy();
        } catch (IllegalArgumentException exception) {
            communicator.printException(exception);
            return BigDecimal.ZERO;
        }
    }

    private List<Integer> confirmJackpotNumbers() {
        List<Integer> jackpotNumbers = new ArrayList<>();
        while (jackpotNumbers.isEmpty()) {
            String jackpotNumbersInput = communicator.instructJackpotNumbers();
            jackpotNumbers = decideJackpotNumbers(jackpotNumbersInput);
        }
        return jackpotNumbers;
    }

    private void confirmBonusAndSave(List<Integer> jackpotNumbers) {
        Bonus bonus = Bonus.emptyBonus();
        while (bonus.isEmpty()) {
            String bonusNumber = communicator.instructBonusNumber();
            bonus = decideAndSave(jackpotNumbers, bonusNumber);
        }
    }

    private List<Integer> decideJackpotNumbers(String jackpotNumbers) {
        try {
            return lottoService.generateJackpotNumbers(jackpotNumbers);
        } catch (IllegalArgumentException exception) {
            communicator.printException(exception);
            return Collections.emptyList();
        }
    }

    private Bonus decideAndSave(List<Integer> numbers, String bonusNumber) {
        try {
            Bonus bonus = lottoService.generateBonus(bonusNumber);
            lottoService.saveJackpotLotto(numbers, bonus);
            return bonus;
        } catch (IllegalArgumentException exception) {
            communicator.printException(exception);
            return Bonus.emptyBonus();
        }
    }
}
