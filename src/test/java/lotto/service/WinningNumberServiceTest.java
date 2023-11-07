package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumberServiceTest {

    WinningNumberService winningNumberService = new WinningNumberService();

    @Test
    void 옳은_값이_들어오면_WinningNumber를_생성한다() {
        WinningNumber winningNumbers = winningNumberService.getWinningNumberIfValid("1,2,3,4,5,6");
        assertEquals(winningNumbers.getNumbers(), List.of(1,2,3,4,5,6));
        assertNotEquals(winningNumbers, null);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1 2 3 4 5 6",
        "asdf,asdf,sdf,sdf,sd,as",
        "1,2,3,3,4,5",
        "1,2,49,284,4,5"
    })
    void 옳은_값이_들어오지_않으면_Purchase를_생성하지_않는다(String winningNumbers) {
        WinningNumber winningNumber = winningNumberService.getWinningNumberIfValid(winningNumbers);
        assertNull(winningNumber);
    }


}