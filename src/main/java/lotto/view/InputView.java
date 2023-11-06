package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InputView {
    private InputView() {}

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        purchaseAmountValidation(input);

        return Integer.parseInt(input);
    }

    private static void purchaseAmountValidation(String input) {
        InputValidation.checkConvertNumber(input);
        InputValidation.checkDivideThousand(input);
        InputValidation.checkMaxRangeNumber(input);
    }

    public static List<Integer> readWinningNumberList() {
        String input = Console.readLine();

        // validation 추가 예정
        
        
        String[] split = input.split(",");
        return Arrays.stream(split).map(Integer::parseInt)
                .collect(toList());
    }

    public static int readBonusNumber() {
        String input = Console.readLine();

        // validation 추가 예정

        return Integer.parseInt(input);
    }

    static class InputValidation {
        private static void checkConvertNumber(String input) {
            for (int i=0; i < input.length(); i++) {
                char checkData = input.charAt(i);
                if (checkData < '0' || checkData > '9') {
                    throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력 가능합니다.");
                }
            }
        }

        private static void checkDivideThousand(String input) {
            int checkData = Integer.parseInt(input);
            if (checkData % 1000 == 0) {
                return;
            }

            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000단위로 입력해야 합니다.");
        }

        private static void checkMaxRangeNumber(String input) {
            int checkData = Integer.parseInt(input);
            if (checkData > 100000) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 100,000원을 넘을 수 없습니다. (100장 까지 구매 가능)");
            }
        }

    }
}
