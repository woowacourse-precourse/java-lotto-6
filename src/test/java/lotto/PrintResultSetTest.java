package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintResultSetTest {
    @DisplayName("일치하는 개수에 따라 동일한 print숫자 변수 값이 +1 업데이트 되어야 한다.")
    @Test
    void checkUpdatePrintNumber() {
        int countMatchThree = 3;
        int expectedPrintThree = 1;
        int expectedPrintFive = 1;
        int expectedPrintFivePlus = 1;
        PrintResultSet testResultSet = new PrintResultSet();
        Score testCountMatchFive = new Score(5, false);
        Score testCountMatchFivePlus = new Score(5, true);

        assertEquals(expectedPrintThree, testResultSet.checkMatchThree(countMatchThree));
        assertEquals(expectedPrintFive, testResultSet.checkMatchFive(testCountMatchFive));
        assertEquals(expectedPrintFivePlus, testResultSet.checkMatchFive(testCountMatchFivePlus));
    }
}