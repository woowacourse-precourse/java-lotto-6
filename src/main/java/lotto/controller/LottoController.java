package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.validation.InputValidation;
import lotto.view.InputView;

public class LottoController {

    InputView inputView = new InputView();
    InputValidation inputValidation = new InputValidation();
    Lottos lottos = new Lottos();

    private static final int LOTTO_TICKET_PRIZE = 1000;

    public void lottoService() {
        int numberOfLottoTickets = purchaseLottoTickets();
        generateLottoTickets(numberOfLottoTickets);
    }

    public String getPurchaseAmount() {
        String purchaseAmount = inputView.purchaseAmountInput();
        inputValidation.validatePurchaseAmountInput(purchaseAmount);
        return purchaseAmount;
    }

    public int purchaseLottoTickets() {
        String purchaseAmount = getPurchaseAmount();
        return calculateNumberOfLottoTickets(purchaseAmount);
    }

    public void generateLottoTickets(int numberOfLottoTickets) {
        for (int i = 0; i < numberOfLottoTickets; i++) {
            Lotto randomLotto = generateRandomLotto();
            randomLotto.sortNumbers();
            lottos.addLotto(randomLotto);
        }
    }

    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
        return parsedPurchaseAmount / LOTTO_TICKET_PRIZE;
    }

    private static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

}
