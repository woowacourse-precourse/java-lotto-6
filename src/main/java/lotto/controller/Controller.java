package lotto.controller;

import lotto.Lotto;
import lotto.view.InputView;
import lotto.utility.Utility;
import lotto.validation.Validation;
import lotto.model.Model;
import lotto.view.OutputView;
import java.util.List;

public class Controller {
    public Controller() {
        InputView inputView = new InputView();
        Utility utility = new Utility();
        Validation validation = new Validation();
        Model model = new Model();
        OutputView outputView = new OutputView();

        String paymentInput = inputView.getPayment();
        int payment = utility.parseInt(paymentInput);
        validation.validateUnit(payment);

        List<Lotto> lottos = model.buyLotto(payment);
        outputView.printAllLottoNumbers(lottos);

        String winningInput = inputView.getWinningNumbers();
        String[] splitResult = utility.splitInput(winningInput);
        List<Integer> winningNumbers = utility.getIntList(splitResult);

        System.out.println(winningNumbers);
    }
}
