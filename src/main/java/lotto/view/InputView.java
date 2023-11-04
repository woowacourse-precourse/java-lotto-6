package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;
import lotto.utils.Casher;
import lotto.utils.Code;
import lotto.utils.Message;

public class InputView {
    private final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";

    public int getLottoCount() {
        System.out.println(INPUT_PRICE);
        String inputPrice = null;
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
        System.out.println(INPUT_WINNING);
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
        System.out.println(INPUT_BONUS);
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

    private List<Integer> inputWinningNumbers(String numbers) {
        String[] split = numbers.split(",");
        Arrays.stream(split).forEach(this::validateNumber);
        if (split.length != 6) {
            throw new IllegalArgumentException(Message.LACK_NUMBER_COUNT.getMessage());
        }
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String inputValue() {
        return Console.readLine();
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOT_NUMBER.getMessage());
        }
    }
}
