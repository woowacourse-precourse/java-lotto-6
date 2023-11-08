package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import java.util.Arrays;
import java.util.List;

class UtilTest {

    @Test
    void countPurchasedLotto() {
        Util util = new Util();
        assertEquals(5, util.countPurchasedLotto(5000), "Should return 5 for 5000 won.");
        assertEquals(0, util.countPurchasedLotto(999), "Should return 0 for 999 won.");
        assertEquals(1, util.countPurchasedLotto(1000), "Should return 1 for 1000 won.");
    }

    @Test
    void generateSixRandomNumber() {
        // This test will use mocking for the Randoms.pickUniqueNumbersInRange method
        try (MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class)) {
            List<Integer> expectedNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
            mockedRandoms.when(() -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                    .thenReturn(expectedNumbers);

            Util util = new Util();
            assertEquals(expectedNumbers, util.generateSixRandomNumber(), "The numbers generated should match the expected mocked numbers.");
        }
    }

    @Test
    void makeLottoNumbersCollection() {
        Util util = new Util();

        try (MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class)) {
            List<Integer> expectedNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
            mockedRandoms.when(() -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                    .thenReturn(expectedNumbers);

            List<List<Integer>> lottoNumbers = util.makeLottoNumbersCollection(3);
            assertEquals(3, lottoNumbers.size());
            assertEquals(expectedNumbers, lottoNumbers.get(0));
            assertEquals(expectedNumbers, lottoNumbers.get(1));
            assertEquals(expectedNumbers, lottoNumbers.get(2));
        }
    }
}
