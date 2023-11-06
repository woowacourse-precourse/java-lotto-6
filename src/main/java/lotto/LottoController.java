package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private final Communicator communicator;
    private final LottoService lottoService;

    public LottoController(Communicator communicator, LottoService lottoService) {
        this.communicator = communicator;
        this.lottoService = lottoService;
    }

    public void run() {
        BigDecimal payment = settlePayment();
        List<Lotto> lotteries = lottoService.generateLotteries(payment);
        communicator.printLotteriesBought(lotteries);

        confirmJackpotLotto();
    }

    private BigDecimal settlePayment() {
        BigDecimal payment = BigDecimal.ZERO;
        while(payment.equals(BigDecimal.ZERO)) {
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

    private void confirmJackpotLotto() {
        List<Integer> jackpotNumbers = confirmJackpotNumbers();
        confirmBonusAndSave(jackpotNumbers);
    }
}
