package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Message;
import lotto.domain.Buyer;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final int NUMBER_START_RANGE = 1;
    private final int NUMBER_END_RANGE = 45;
    private final int METHOD_PURCHASE_AMOUNT = 1;

    private final String REGEX_PATTERN_NO_NUMBER = "^[\\d]*$";

    private final Buyer buyer = new Buyer();

    public void purchaseLotto(String input) {

        savePurchaseAmount(input);

        int amount = buyer.getAmount();

        savePurchaseNumbers(amount);
    }

    private void savePurchaseAmount(String input) {

        validateInput(input, 1);

        int money = Integer.parseInt(input);
        buyer.saveAmount(money);
    }

    private void savePurchaseNumbers(int amount) {

        for(int i=0; i<amount; i++) {

            List<Integer> numbers = createNumbers();

            buyer.saveNumbers(numbers);
        }
    }

    public int getPurchaseAmount() {

        return buyer.getAmount();
    }

    private List<Integer> createNumbers() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {

            int number = Randoms.pickNumberInRange
                    (NUMBER_START_RANGE, NUMBER_END_RANGE);

            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return numbers;
    }

    private void validateInput(String input, int methodName) {

        String REGEX = REGEX_PATTERN_NO_NUMBER;

        String removeComma = input.replaceAll("\\,", "");

        if (!removeComma.matches(REGEX)) {

            findErrorMethod(methodName);
        }
    }

    private void findErrorMethod(int methodName) {

        if (methodName == 1) {

            throw new IllegalArgumentException(Message.INPUT_MONEY_ERROR_MESSAGE.getMessage());
        }
    }
}
