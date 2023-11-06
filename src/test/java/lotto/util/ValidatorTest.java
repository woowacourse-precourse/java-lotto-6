package lotto.util;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import lotto.configure.ErrorMessages;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ValidatorTest {

    @Test
    void testCheckIfInteger_includeNonNumber() {
        String[] testCases = {
                "13 ",
                " 256",
                "78!",
                "a95",
                "9!3",
                " 10 2"
        };

        for (String testCase : testCases) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkIfInteger(testCase))
                    .withMessageContaining(ErrorMessages.NOT_AN_INTEGER.get());
        }
    }

    @Test
    void testCheckIfInteger_tryRealNumber() {
        String[] testCases = {
                "3.14",
                "56.25",
                "13.99"
        };

        for (String testCase : testCases) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkIfInteger(testCase))
                    .withMessageContaining(ErrorMessages.NOT_AN_INTEGER.get());
        }
    }

    @Test
    void testCheckIfInteger_noExceptionCase_onlyIntegers() {
        String[] testCases ={
                "15",
                "6",
                "0",
                "1",
                "-13",
                "-1",
                "146135812",
                "-156165824"
        };

        for (String testCase : testCases) {
            assertThatNoException().isThrownBy(() -> Validator.checkIfInteger(testCase));
        }
    }

    @Test
    void testCheckIfNonNegative_includeNegativeIntegers() {
        int[] testCases = {
                -15,
                -1,
                -142658124
        };

        for (int testCase : testCases) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkIfNonNegative(testCase))
                    .withMessageContaining(ErrorMessages.PURCHASE_NUMBER_IS_NEGATIVE.get());
        }
    }

    @Test
    void testCheckIfNonNegative_onlyNonNegativeIntegers_noException() {
        int[] testCases = {
                0,
                1,
                13515481
        };

        for (int testCase : testCases) {
            assertThatNoException().isThrownBy(() -> Validator.checkIfNonNegative(testCase));
        }
    }

    @Test
    void testCheckIfMultipleOfThousand_notMultipleOfThousand() {
        int[] testCases = {
                -153, 56, 901,
                1001, 1850137414
        };

        for (int testCase : testCases) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkIfMultipleOfThousand(testCase))
                    .withMessageContaining(ErrorMessages.PURCHASE_NUMBER_IS_NOT_MULTIPLE_OF_1000.get());
        }
    }

    @Test
    void testCheckIfMultipleOfThousand_multipleOfThousand_noException() {
        int[] testCases = {
                -1000, 0, 1000, 1000000
        };

        for (int testCase : testCases) {
            assertThatNoException().isThrownBy(() -> Validator.checkIfMultipleOfThousand(testCase));
        }
    }

    @Test
    void testCheckIfWinningNumbersAreInteger_containsNonNumbers() {
        String[] testCases = {
                "1 ,2,3,4,5",
                "13,45,5!,78,90",
                "61,a4,56,3",
                ",1,2,3,4",
                ",561,251,-35,51,"
        };

        for (String testCase : testCases) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkIfWinningNumbersAreInteger(testCase))
                    .withMessageContaining(ErrorMessages.NOT_AN_INTEGER.get());
        }
    }

    @Test
    void testCheckIfWinningNumbersAreInteger_containsRealNumbers() {
        String[] testCases = {
                "1,2,3.14,4,5",
                "13.5,45.3,5.61.291,78.44,90.1524",
                "61,a4,56.5,3"
        };

        for (String testCase : testCases) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkIfWinningNumbersAreInteger(testCase))
                    .withMessageContaining(ErrorMessages.NOT_AN_INTEGER.get());
        }
    }

    @Test
    void testCheckIfWinningNumbersAreInteger_containsOnlyIntegers_noException() {
        String[] testCases = {
                "1,2,3,4,5",
                "0,1,2,3,4",
                "13",
                "0",
                "5,6,7,8",
                "10,13,15,17,19,",
                "156,253,124,-325,"
        };

        for (String testCase : testCases) {
            assertThatNoException().isThrownBy(() -> Validator.checkIfWinningNumbersAreInteger(testCase));
        };
    }

    @Test
    void testCheckIfWinningNumbersAreSix_notSix() {
        List<List<Integer>> testCases = Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1, 15),
                Arrays.asList(3, 6, 9, 12, 15, 18, 24)
        );

        testCases.forEach((l) -> {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkIfWinningNumbersAreSix(l))
                    .withMessageContaining(ErrorMessages.WINNING_NUMBERS_ARE_NOT_SIX.get());
        });
    }

    @Test
    void testCheckIfWinningNumbersAreSix_noException() {
        List<Integer> testCase = Arrays.asList(3, 6, 9, 12, 15, 18);
        assertThatNoException()
                .isThrownBy(() -> Validator.checkIfWinningNumbersAreSix(testCase));
    }

    @Test
    void testCheckRangeOfEachWinningNumber_oneViolation() {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(0, 13, 25, 26, 38, 40),
                Arrays.asList(1, 0, 25, 26, 27, 28),
                Arrays.asList(3, 6, -25, 37, 40, 44),
                Arrays.asList(25, 27, 29, 30, 31, 478)
        );

        testCases.forEach((l) -> {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkRangeOfEachWinningNumber(l))
                    .withMessageContaining(ErrorMessages.WINNING_NUMBERS_NOT_IN_PROPER_RANGE.get());
        });
    }

    @Test
    void testCheckRangeOfEachWinningNumber_twoViolation() {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(0, -1, 25, 26, 38, 40),
                Arrays.asList(1, 0, 47, 26, 27, 28),
                Arrays.asList(3, 6, -25, 0, 40, 44),
                Arrays.asList(25, 27, 29, 30, 59, 478)
        );

        testCases.forEach((l) -> {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkRangeOfEachWinningNumber(l))
                    .withMessageContaining(ErrorMessages.WINNING_NUMBERS_NOT_IN_PROPER_RANGE.get());
        });
    }

    @Test
    void testCheckRangeOfEachWinningNumber_sixViolation() {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(-256, -25, 0, 48, 49, 70)
        );

        testCases.forEach((l) -> {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkRangeOfEachWinningNumber(l))
                    .withMessageContaining(ErrorMessages.WINNING_NUMBERS_NOT_IN_PROPER_RANGE.get());
        });
    }

    @Test
    void testCheckRangeOfEachWinningNumber_noViolation_noException() {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 3, 5, 7, 9, 11),
                Arrays.asList(1, 2, 3, 4, 5, 45)
        );

        testCases.forEach((l) -> {
            assertThatNoException()
                    .isThrownBy(() -> Validator.checkRangeOfEachWinningNumber(l));
        });
    }

    @Test
    void testCheckRangeOfBonusNumber_violate() {
        Integer[] testCases = {
                -125142, -1, 0, 46, 4774, 1412425
        };

        Arrays.asList(testCases).forEach(e -> {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.checkRangeOfBonusNumber(e))
                    .withMessageContaining(ErrorMessages.BONUS_NUMBER_NOT_IN_PROPER_RANGE.get());
        });
    }

    @Test
    void testCheckRangeOfBonusNumber_noException() {
        Integer[] testCases = {
                1, 2, 33, 44, 45
        };

        Arrays.asList(testCases).forEach(e -> {
            assertThatNoException().isThrownBy(() -> Validator.checkRangeOfBonusNumber(e));
        });
    }
}