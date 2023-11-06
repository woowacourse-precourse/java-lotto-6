package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;
import lotto.utils.Casher;
import lotto.utils.enums.Code;
import lotto.utils.enums.ErrorMessage;

public class InputView {
    private final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";

    private String inputPrice;

    public int getLottoCount() {
        System.out.println("\n" + INPUT_PRICE);
        int lottoCount = 0;
        Casher casher = new Casher();
        while (true) {
            inputPrice = inputValue();
            try {
                validateNumber(inputPrice);
                lottoCount = casher.getLottoCount(Integer.parseInt(inputPrice));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Code.Error.getCode() + " " + e.getMessage());
            }
        }
        return lottoCount;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("\n" + INPUT_WINNING);
        String numbers = null;
        WinningNumbers winning = null;
        while (true) {
            numbers = inputValue();
            try {
                List<Integer> winningNumbers = inputWinningNumbers(numbers);
                winning = new WinningNumbers(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Code.Error.getCode() + " " + e.getMessage());
            }
        }
        return winning.getNumbers();
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n" + INPUT_BONUS);
        String number = null;
        BonusNumber bonusNumber = null;
        while (true) {
            number = inputValue();
            try {
                validateNumber(number);
                bonusNumber = new BonusNumber(winningNumbers, Integer.parseInt(number));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Code.Error.getCode() + " " + e.getMessage());
            }
        }
        return bonusNumber.getBonusNumber();
    }

    private List<Integer> inputWinningNumbers(String numbers) throws IllegalArgumentException{
        String[] split = numbers.split(",");
        Arrays.stream(split).forEach(this::validateNumber);
        if (split.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.LACK_NUMBER_COUNT.getMessage());
        }
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNumber(String input) throws IllegalArgumentException{
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BLANK_NUMBER.getMessage());
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public int getInputPrice() {
        return Integer.parseInt(inputPrice);
    }

    private String inputValue() {
        return Console.readLine();
    }
}
