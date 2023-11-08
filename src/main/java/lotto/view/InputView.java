package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static lotto.domain.ErrorMessage.*;

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

    public static int readBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        checkBonusNumber(winningNumbers, input);

        return Integer.parseInt(input);
    }

    private static void checkBonusNumber(List<Integer> winningNumbers, String input) {
        InputValidation.checkBonusConvertNumber(input);
        InputValidation.checkBonusNumberRange(input);
        InputValidation.checkBonusNumberDuplication(winningNumbers, input);
    }

    static class InputValidation {
        private static final int THOUSAND = 1000;
        private static final int ZERO = 0;
        private static final int MAX_PURCHASE_AMOUNT = 100000;
        private static final int SIX = 6;
        private static final int ONE = 1;
        private static final int FORTY_FIVE = 45;

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
                throw new IllegalArgumentException(PURCHASE_AMOUNT_CONVERT_EXCEPTION.getMessage());
            }
        }

        private static void checkDivideThousand(String input) {
            int checkData = Integer.parseInt(input);
            if (checkData % THOUSAND == ZERO) {
                return;
            }

            throw new IllegalArgumentException(PURCHASE_AMOUNT_THOUSAND_EXCEPTION.getMessage());
        }

        private static void checkMaxRangeNumber(String input) {
            int checkData = Integer.parseInt(input);
            if (checkData > MAX_PURCHASE_AMOUNT) {
                throw new IllegalArgumentException(
                        PURCHASE_AMOUNT_MAXVALUE_EXCEPTION.getMaxValueMessage(String.valueOf(MAX_PURCHASE_AMOUNT))
                );
            }
        }

        private static void checkNumberSixCount(String input) {
            String[] checkData = input.split(",");
            if (checkData.length != SIX) {
                throw new IllegalArgumentException(WINNING_NUMBER_SIX_EXCEPTION.getMessage());
            }
        }

        private static void checkWinningNumbersConvertNumber(String input) {
            String[] checkNumbers = input.split(",");
            for (String checkNumber : checkNumbers) {
                if (!isInteger(checkNumber)) {
                    throw new IllegalArgumentException(WINNING_NUMBER_CONVERT_EXCEPTION.getMessage());
                }
            }
        }

        private static void checkWinningNumbersRange(String input) {
            String[] checkDatas = input.split(",");
            for (String checkNumber : checkDatas) {
                if (!isLottoNumberRange(checkNumber)) {
                    throw new IllegalArgumentException(WINNING_NUMBER_RANGE_EXCEPTION.getMessage());
                }
            }
        }

        private static boolean isLottoNumberRange(String input) {
            int checkNumber = Integer.parseInt(input);

            return checkNumber >= ONE && checkNumber <= FORTY_FIVE;
        }

        private static void checkWinningNumbersDuplication(String input) {
            String[] checkDatas = input.split(",");
            if (!isDuplicate(checkDatas)) {
                throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_EXCEPTION.getMessage());
            }
        }

        private static boolean isDuplicate(String[] checkDatas) {
            Set<Integer> set = new HashSet<>();
            int count = 0;
            for (String checkData : checkDatas) {
                count++;
                set.add(Integer.parseInt(checkData));
            }

            return set.size() == count;
        }

        private static void checkBonusConvertNumber(String input) {
            if (!isInteger(input)) {
                throw new IllegalArgumentException(BONUS_NUMBER_CONVERT_EXCEPTION.getMessage());
            }
        }

        private static void checkBonusNumberRange(String input) {
            if (!isLottoNumberRange(input)) {
                throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION.getMessage());
            }
        }

        private static void checkBonusNumberDuplication(List<Integer> winningList, String bonusNumber) {
            String[] checkDatas = convertCheckDatas(winningList, bonusNumber);

            if (!isDuplicate(checkDatas)) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION.getMessage());
            }
        }

        private static String[] convertCheckDatas(List<Integer> winningList, String bonusNumber) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : winningList) {
                sb.append(integer).append(",");
            }
            sb.append(bonusNumber);

            return sb.toString().split(",");
        }
    }
}
