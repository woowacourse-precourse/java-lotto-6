package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Payment;
import lotto.service.LottoService;
import lotto.utils.InputValidator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();
    LottoService lottoService = new LottoService();

    public void proceedLottos() {
        Payment userPayment = buyLottos();
        Lottos userLottos = lottoService.createUserLottos(userPayment.providePaymentStatus().get(1));
        Lotto answerLotto = setAnswerLotto();
        BonusNumber bonusNumber = setBonusNumber();
    }

    private Payment buyLottos() {
        try {
            String lottoAmount = inputView.askPaymentAmount();
            String preprocessedLottoAmount = inputValidator.preprocessUserInput(lottoAmount);
            int validLottoAmount = inputValidator.convertInputToPaymentAmount(preprocessedLottoAmount);
            Payment payment = new Payment(validLottoAmount);
            return payment;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottos();
        }
    }

    private Lotto setAnswerLotto() {
        try {
            String answerLottoNumbers = inputView.askAnswerLottoNumbers();
            String preprocessedNumbers = inputValidator.preprocessUserInput(answerLottoNumbers);
            List<Integer> validAnswerNumbers = inputValidator.convertInputToLottoNumbers(preprocessedNumbers);
            return lottoService.createAnswerLotto(validAnswerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setAnswerLotto();
        }
    }

    private BonusNumber setBonusNumber() {
        try {
            String userBonusNumber = inputView.askBonusNumber();
            String preprocessedBonusNumber = inputValidator.preprocessUserInput(userBonusNumber);
            Integer validBonusNumber = inputValidator.convertInputToBonusNumber(preprocessedBonusNumber);
            return new BonusNumber(validBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumber();
        }
    }
}
