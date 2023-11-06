package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoMachine lottoMachine;

    LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoMachine = new LottoMachine();
    }

    public void start() {
        List<Lotto> tickets = buyLotto();
        showTickets(tickets);
        Lotto userLotto = getUserLotto();
        int bonusNumber = getBonusNumber(userLotto);
    }

    private List<Lotto> buyLotto() {
        try {
            int money = inputView.inputPurchaseAmount();
            return lottoMachine.buy(money);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return buyLotto();
        }
    }

    private void showTickets(List<Lotto> tickets) {
        List<String> numbers = new ArrayList<>();
        for (Lotto lotto : tickets) {
            numbers.add(lotto.toString());
        }
        outputView.printGeneratedLotto(numbers);
    }

    private Lotto getUserLotto() {
        try {
            List<Integer> numbers = inputView.inputWinningNumbers();
            return new Lotto(numbers);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getUserLotto();
        }
    }

    private int getBonusNumber(Lotto userLotto) {
        try {
            int bonusNumber = inputView.inputBonusNumber();
            validateBonusNumber(userLotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getBonusNumber(userLotto);
        }
    }

    private void validateBonusNumber(Lotto userLotto, int bonusNumber) {
        if (userLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("번호가 모두 달라야 합니다");
        }
    }
}
