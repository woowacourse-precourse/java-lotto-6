package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.message.InputExceptionMessage;
import lotto.model.Lotto;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String ONLY_NUMBER = "^[0-9]+$";
    private static final String VALID_LOTTO_NUMBER_PATTERN = "^[1-9]|[1-3][0-9]|4[0-5]+$";
    private static final String VALID_LOTTO_LIST_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5])$";

    public int receiveTotalPrice() {
        while (true) {
            String input = Console.readLine();

            if (!input.matches(ONLY_NUMBER)) {
                System.out.println(InputExceptionMessage.INVALID_PRICE_TYPE);
                continue;
            }

            int totalPrice = Integer.parseInt(input);

            if (totalPrice % LOTTO_PRICE != 0) {
                System.out.println(InputExceptionMessage.INVALID_PRICE);
                continue;
            }
            return totalPrice;
        }
    }

    public Lotto receiveLottoWinning() {
        while (true) {
            String input = Console.readLine();

            if (!input.matches(VALID_LOTTO_LIST_PATTERN)) {
                System.out.println(InputExceptionMessage.INVALID_LOTTO_NUMBERS);
                continue;
            }

            Optional<List<Integer>> optionalList = getValidWinningList(input);
            if (optionalList.isEmpty()) {
                continue;
            }

            return new Lotto(optionalList.get());
        }
    }

    public int receiveBonusNumber(Lotto lotto) {
        while (true) {
            String input = Console.readLine();
            if (!input.matches(VALID_LOTTO_NUMBER_PATTERN)) {
                System.out.println(InputExceptionMessage.INVALID_BONUS_NUMBER);
                continue;
            }
            int num = Integer.parseInt(input);

            if (lotto.getNumbers().contains(num)) {
                System.out.println(InputExceptionMessage.DUPLICATED_BONUS_NUMBER);
                continue;
            }

            return num;
        }
    }

    private static Optional<List<Integer>> getValidWinningList(String input) {
        List<Integer> winningList = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .filter(n -> n >= 1 && n <= 45)
                .sorted(Integer::compare)
                .toList();

        long uniqueLength = winningList.stream().distinct().count();

        if (winningList.size() != uniqueLength) {
            System.out.println(InputExceptionMessage.INVALID_LOTTO_DUPLICATED);
            return Optional.empty();
        }
        return Optional.of(winningList);
    }
}
