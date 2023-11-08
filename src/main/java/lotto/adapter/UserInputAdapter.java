package lotto.adapter;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ExceptionHandler;
import lotto.port.InputPort;

public class UserInputAdapter implements InputPort {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_DRAW_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    @Override
    public Integer readBudget() {
        System.out.println(INPUT_PURCHASE_AMOUNT);

        while (true) {
            String input = Console.readLine();
            try {
                // 유효성 검사 로직
                boolean isInputEmpty = input.isEmpty();
                if (isInputEmpty) {
                    ExceptionHandler.handleException(new IllegalArgumentException(), "빈 문자열을 입력할 수 없습니다.");
                }
                try {
                    Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    ExceptionHandler.handleException(e, "올바른 정수 형태가 아닙니다.");
                }
                Integer budget = Integer.parseInt(input);
                boolean isBudgetAmountNegative = budget < 0;
                if (isBudgetAmountNegative) {
                    ExceptionHandler.handleException(new IllegalArgumentException(), "로또 구입 금액은 음수일 수 없습니다.");
                }
                boolean isBudgetAmountZero = budget == 0;
                if (isBudgetAmountZero) {
                    ExceptionHandler.handleException(new IllegalStateException(), "로또 구입 금액은 0원이 될 수 없습니다.");
                }
                boolean isBudgetAmountInvalid = Integer.parseInt(input) % 1000 == 0;
                if (isBudgetAmountInvalid) {
                    ExceptionHandler.handleException(new IllegalArgumentException(), "로또 구입 금액은 1000원 단위여야 합니다.");
                }
            } catch (Exception e) {
                continue;
            }

            return Integer.parseInt(input);
        }
    }

    @Override
    public List<Integer> readDrawNumbers() {
        System.out.println(INPUT_DRAW_NUMBERS);
        String input = Console.readLine();

        // TODO: 유효성 검사 로직 추가

        return Arrays.stream(input.replaceAll(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Integer readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();

        // TODO: 유효성 검사 로직 추가

        return Integer.parseInt(input);
    }
}
