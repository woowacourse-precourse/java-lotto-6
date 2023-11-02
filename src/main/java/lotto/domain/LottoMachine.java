package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.InputValidator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumberConstants.*;

public class LottoMachine {

    public int purchaseLotto() {

        while (true) {
            String input = InputView.PurchaseAmount();
            if (InputValidator.isNumeric(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public int calculateAmount(int amount) {

        if (InputValidator.isCalculate(amount)) {
            return amount / LOTTO_PRICE.getValue();
        }
        return -1;
    }

    public Lotto createLotto() {

        List<Integer> randomSixNumbers = pickLottoNumber();
        return new Lotto(randomSixNumbers);
    }

    private static List<Integer> pickLottoNumber() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() != WINNING_NUMBER_TOTAL.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_NUMBER_MIN_RANGE.getValue(),
                    LOTTO_NUMBER_MAX_RANGE.getValue());

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
