package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    private WinningResult winningResult = new WinningResult();

    @DisplayName("1등 당첨 개수를 증가시킨다.")
    @Test
    void increaseFirstPlaceNumber(){
        int numberOfMatches = 6;
        boolean bonusNumberMatches = false;

        winningResult.addResults(numberOfMatches, bonusNumberMatches);

        Assertions.assertEquals(1, winningResult.getNumberOfFirst());
    }

    @DisplayName("2등 당첨 개수를 증가시킨다.")
    @Test
    void increaseSecondPlaceNumber(){
        int numberOfMatches = 5;
        boolean bonusNumberMatches = true;

        winningResult.addResults(numberOfMatches, bonusNumberMatches);

        Assertions.assertEquals(1, winningResult.getNumberOfSecond());
    }
}
