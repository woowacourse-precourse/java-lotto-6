package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.Comparison;
import lotto.controller.Counting;
import lotto.model.Cash;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void testCompareLotto() {
        Comparison comparison = new Comparison();
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Test case 1: No matching numbers
        List<Integer> randomNumbers1 = Arrays.asList(7, 8, 9, 10, 11, 12);
        int result1 = comparison.compareLotto(lottoNumbers, randomNumbers1);
        assertEquals(0, result1);

        // Test case 2: Some matching numbers
        List<Integer> randomNumbers2 = Arrays.asList(3, 5, 7, 8, 9, 10);
        int result2 = comparison.compareLotto(lottoNumbers, randomNumbers2);
        assertEquals(2, result2);

        // Test case 3: All numbers matching
        List<Integer> randomNumbers3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result3 = comparison.compareLotto(lottoNumbers, randomNumbers3);
        assertEquals(6, result3);
    }

    @Test
    void testCompareBonus() {
        Comparison comparison = new Comparison();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Test case 1: Bonus number not in the list
        int bonusNum1 = 10;
        assertFalse(comparison.compareBonus(numbers, bonusNum1));

        // Test case 2: Bonus number in the list
        int bonusNum2 = 3;
        assertTrue(comparison.compareBonus(numbers, bonusNum2));
    }

    @Test
    void testGetResult() {
        Counting counting = new Counting();
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // 6 numbers match
        int bonusNumber = 7;
        int result1 = counting.getResult(lottoNumbers, bonusNumber, randomNumbers);
        assertEquals(6, result1);

        // 3 numbers match
        List<Integer> randomNumbers3 = Arrays.asList(1, 2, 3, 7, 8, 9);
        int bonusNumber3 = 10;
        int result3 = counting.getResult(lottoNumbers, bonusNumber3, randomNumbers3);
        assertEquals(3, result3);
    }



    @Test
    void testSizeCheck() {
        // Test case 1: Valid size (6 numbers)
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(numbers1); // No exception should be thrown

        // Test case 2: Invalid size (5 numbers)
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers2));

        // Test case 3: Invalid size (7 numbers)
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers3));
    }

    @Test
    void testRangeCheck() {
        // Test case 1: All numbers are within the valid range
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(numbers1); // No exception should be thrown

        // Test case 2: Some numbers are out of range
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers2));
    }

    @Test
    void testDuplicationCheck() {
        // Test case 1: No duplicate numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(numbers1); // No exception should be thrown

        // Test case 2: Duplicate numbers
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers2));
    }

    @Test
    void testCashCheckValid() {
        // Test case 1: Valid cash amount (1000)
        Cash cash1 = new Cash(1000); // No exception should be thrown

        // Test case 2: Valid cash amount (multiple of 1000)
        Cash cash2 = new Cash(3000); // No exception should be thrown
    }

    @Test
    void testCashCheckInvalid() {
        // Test case 1: Invalid cash amount (less than 1000)
        assertThrows(IllegalArgumentException.class, () -> new Cash(999));

        // Test case 2: Invalid cash amount (not multiple of 1000)
        assertThrows(IllegalArgumentException.class, () -> new Cash(1500));
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
