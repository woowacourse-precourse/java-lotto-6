package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    static WinningNumber winningNumber;
    static String winningNumbers = "1,2,3,4,5,6,7";
    static boolean[] numbersExist;

    @BeforeAll
    static void prepare() {
        winningNumber = new WinningNumber(winningNumbers);
        numbersExist =  winningNumber.getNumbersExist();
    }

    @DisplayName("인자로 넘기는 번호가 실제 당첨 번호인지 체크")
    @ParameterizedTest
    @CsvSource({
            "3, true",
            "4, true",
            "10, false",
            "11, false"
    })
    void testNumbersExist(int number, boolean expectedExist) {
        assertThat(numbersExist[number]).isEqualTo(expectedExist);
    }

}