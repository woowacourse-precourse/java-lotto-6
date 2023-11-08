package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.message.ErrorMessage;
import lotto.validation.InputValidator;

public class InputView {

    private static final String DELIMITER = ",";
    InputValidator validator = new InputValidator();

    public int getLottoPrice() {
        String inputPrice;
        do {
            inputPrice = Console.readLine();
        } while (!validator.validateInputPrice(inputPrice));

        return Integer.parseInt(inputPrice);
    }

    public int getBonusNumber() {
        String inputBonusNumber;
        int bonusNumber;
        do {
            inputBonusNumber = Console.readLine();
        } while (!validator.validateInputBonusNumber(inputBonusNumber));
        bonusNumber = Integer.parseInt(inputBonusNumber);

        return bonusNumber;
    }

    public String getWinnerLotto() {
        String inputWinner;
        do {
            inputWinner = Console.readLine();
        } while (!validator.validateInputWinnerLotto(inputWinner));

        List<Integer> winnerLotto;
        winnerLotto = getIntList(inputWinner);
        return inputWinner;
    }

    public List<Integer> getWinnerLottoPaper(String inputWinner) {
        List<Integer> winnerLotto = new ArrayList<>();
        try {
            winnerLotto = getIntList(inputWinner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return winnerLotto;
    }

    private List<Integer> getIntList(String input) {
        List<Integer> winnerLotto = new ArrayList<>();
        int[] inputWinner;
        try {
            inputWinner = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
            winnerLotto = Arrays.stream(inputWinner).boxed()
                .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.REQUEST_INT_LIST.getErrorMessage());
        }
        return winnerLotto;
    }
}
