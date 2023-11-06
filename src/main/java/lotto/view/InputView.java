package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class InputView {
    private InputView() {}

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        checkPurchaseAmountInput(input);

        return Integer.parseInt(input);
    }

    private static void checkPurchaseAmountInput(String input) {
        InputValidation.checkPurchaseAmountConvertNumber(input);
        InputValidation.checkDivideThousand(input);
        InputValidation.checkMaxRangeNumber(input);
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        checkWinningNumbersInput(input);

        String[] split = input.split(",");
        return Arrays.stream(split).map(Integer::parseInt)
                .collect(toList());
    }

    private static void checkWinningNumbersInput(String input) {
        InputValidation.checkNumberSixCount(input);
        InputValidation.checkWinningNumbersConvertNumber(input);
        InputValidation.checkWinningNumbersRange(input);
        InputValidation.checkWinningNumbersDuplication(input);
    }

    public static int readBonusNumber() {
        String input = Console.readLine();

        // validation 추가 예정
        //InputValidation.checkBonusConvertNumber(input);


        return Integer.parseInt(input);
    }

    static class InputValidation {
        private static boolean isInteger(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private static void checkPurchaseAmountConvertNumber(String input) {
            if (!isInteger(input)) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력 가능합니다.");
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

        private static void checkNumberSixCount(String input) {
            String[] checkData = input.split(",");
            if (checkData.length != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 ',' 기준으로 6자리를 입력해야 합니다.");
            }
        }

        private static void checkWinningNumbersConvertNumber(String input) {
            String[] checkNumbers = input.split(",");
            for (String checkNumber : checkNumbers) {
                if (!isInteger(checkNumber)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
                }
            }
        }

        private static void checkWinningNumbersRange(String input) {
            String[] checkDatas = input.split(",");
            for (String checkNumber : checkDatas) {
                if (!isWinningNumberRange(checkNumber)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45까지 가능합니다.");
                }
            }
        }

        private static boolean isWinningNumberRange(String input) {
            int checkNumber = Integer.parseInt(input);

            return checkNumber >= 1 && checkNumber <= 45;
        }

        private static void checkWinningNumbersDuplication(String input) {
            String[] checkDatas = input.split(",");
            if (!isDuplicate(checkDatas)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
        }

        private static boolean isDuplicate(String[] checkDatas) {
            Set<Integer> set = new HashSet<>();
            for (String checkData : checkDatas) {
                set.add(Integer.parseInt(checkData));
            }

            return set.size() == 6;
        }

        /*private static void checkBonusConvertNumber(String input) {
            if (!isInteger(input)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
            }
        }*/




    }
}
