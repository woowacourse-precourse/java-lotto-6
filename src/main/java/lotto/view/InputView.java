package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.constant.ErrorMessage;

public class InputView {

    public int getPurchaseAmount() {
        String input = Console.readLine();
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (Exception exception) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER.getMessage());
        }
        return amount;
    }

    public List<Integer> getWinningNumbers() {
        try {
            String input = Console.readLine();
            Stream<String> streamInput = Arrays.stream(input.split(","));
            Stream<Integer> numbers;
            numbers = streamInput.map(Integer::parseInt);
            return numbers.toList();
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER.getMessage());
        }
//        catch ()
    }

    public int getBonusNumber() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER.getMessage());
        }
    }
}
