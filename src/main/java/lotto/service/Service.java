package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import lotto.model.Lotto;
import lotto.view.exception.InvalidNumberException;
import lotto.view.exception.InvalidStringSplitException;

public class Service {
    private static final int ZERO = 0;
    private static final int MIN_NUMBER = 1;
    private static final int SIZE = 6;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> createLottos(int TicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO; i < TicketCount; i++) {
            lottos.add(createRandomLottoNumber());
        }
        return lottos;
    }

    public Lotto createRandomLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE);
        return new Lotto(numbers);
    }

    public List<Integer> splitStringToIntegerList(String winningNumber) {
        List<String> splitNumbers = validateStringForSplit(winningNumber);
        return validateNumbers(splitNumbers);
    }

    private List<String> validateStringForSplit(String winningNumber) {
        try {
            return List.of(winningNumber.split(","));
        } catch (PatternSyntaxException e) {
            throw new InvalidStringSplitException();
        }
    }

    private List<Integer> validateNumbers(List<String> winningNumber) {
        List<Integer> validNumbers = new ArrayList<>();
        for (String numberString : winningNumber) {
            try {
                int number = Integer.parseInt(numberString);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new InvalidNumberException();
            }
        }
        return validNumbers;
    }

}
