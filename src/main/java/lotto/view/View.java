package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class View {

    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_ANSWER_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public int getLottoSize() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);

        String input = Console.readLine();
        System.out.println();
        return getPurchaseAmount(input) / Constant.LOTTO_PRICE.getValue();
    }

    public List<Integer> getAnswerNumber() {
        System.out.println(PROMPT_ANSWER_NUMBER);
        try {
            String input = Console.readLine();
            Stream<String> steamInput = Arrays.stream(input.split(","));
            Stream<Integer> numbers;
            numbers = steamInput.map(Integer::parseInt);
            System.out.println();
            return numbers.toList();
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER.getMessage());
        }
    }

    public int getBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
        try {
            String input = Console.readLine();
            System.out.println();
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER.getMessage());
        }
    }

    private int getPurchaseAmount(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER.getMessage());
        }
        if (amount % Constant.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE.getMessage());
        }
        return amount;
    }
}
