package ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;
import lotto.LottoWinningNumber.Builder;
import ui.validator.MoneyValidator;

class InputView {
    private InputView() {
    }

    /**
     * @return 1000 단위로 끊어진 로또 구매 금액.
     */
    public static int getMoney() {
        return repeat(() -> {
            String input = Console.readLine();
            int money = Integer.parseInt(input);
            MoneyValidator.verify(money);
            return money;
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

    private static <R> R repeat(Callable<R> supplier) {
        while (true) {
            try {
                return supplier.call();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] Unexpected Exception");
            }
        }
    }
}
