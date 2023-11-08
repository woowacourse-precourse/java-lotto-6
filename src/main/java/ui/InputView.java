package ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lotto.LottoMoney;
import lotto.LottoWinningNumber.Builder;
import msg.ErrorMessage;

class InputView {
    private InputView() {
    }

    /**
     * @return 1000 단위로 끊어진 로또 구매 금액.
     */
    public static LottoMoney getMoney() {
        return repeat(() -> {
            String input = Console.readLine();
            int money = Integer.parseInt(input);
            return new LottoMoney(money);
        });
    }

    public static Builder getCommonNumbers(Builder builder) {
        return repeat(() -> {
            String input = Console.readLine();
            String[] inputNumbers = input.split(",");

            List<Integer> numbers = Stream.of(inputNumbers).map(Integer::parseInt).toList();

            return builder.commonNumbers(numbers);
        });
    }

    public static Builder getBonusNumber(Builder builder) {
        return repeat(() -> {
            String input = Console.readLine();
            int number = Integer.parseInt(input);

            return builder.bonusNumber(number);

        });
    }

    private static <R> R repeat(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_A_NUMBER.value());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
