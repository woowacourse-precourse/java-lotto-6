package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {
    
    @Test
    @DisplayName("수익률이 맞는지 테스트")
    void benefit_test() {
        ArrayList<LottoResult> matchResults = new ArrayList<>();

        matchResults.add(LottoResult.getResult(0, false));
        matchResults.add(LottoResult.getResult(2, false));
        
       
        assertEquals(0.0, Output.calculateLottoEarnings(matchResults, 2000));

        matchResults.add(LottoResult.getResult(3, false));
         assertEquals(50.0, Output.calculateLottoEarnings(matchResults, 10000));
         matchResults.add(LottoResult.getResult(5, false));
        assertEquals(15050.0, Output.calculateLottoEarnings(matchResults, 10000));
    }
}
