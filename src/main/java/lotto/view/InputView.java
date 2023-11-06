package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.InputValidator;

public class InputView {

    InputValidator validator = new InputValidator();

    public int getLottoPrice() {
        String inputPrice = Console.readLine();
        int price = validator.validateInputPrice(inputPrice);

        return price;
    }

    public int getBonusNumber() {
        String inputBonusNumber = Console.readLine();
        int bonusNumber;
        bonusNumber = validator.validateInputBonusNumber(inputBonusNumber);

        return bonusNumber;
    }

    public List<Integer> getWinnerLotto() {
        String inputWinner = Console.readLine();
        List<Integer> winnerLotto = validator.validateInputWinnerLotto(inputWinner);

        return winnerLotto;
    }

}
