package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import model.enums.LottoWinResults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinResultsHolderTest {
    private static LottoWinResultsHolder lottoWinResultsHolder;
    @BeforeAll
    static void beforeAll() {
        lottoWinResultsHolder = new LottoWinResultsHolder();
    }

    @DisplayName("LottoWinResultsHolder 값 저장 후 반환 테스트")
    @Test
    void lottoWinResultsHolderTest() {
        lottoWinResultsHolder.lottoWinResultsAdd(LottoWinResults.LOTTO_3SAME.getMessage());
        lottoWinResultsHolder.lottoWinResultsAdd(LottoWinResults.LOTTO_5SAME.getMessage());
        lottoWinResultsHolder.lottoWinResultsAdd(LottoWinResults.LOTTO_6SAME.getMessage());
        Map<String, Integer> winResults =  new HashMap<>();
        winResults.put(LottoWinResults.LOTTO_3SAME.getMessage() ,1);
        winResults.put(LottoWinResults.LOTTO_4SAME.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_5SAME.getMessage() ,1);
        winResults.put(LottoWinResults.LOTTO_5SAME_BONUS.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_6SAME.getMessage() ,1);
        assertThat(lottoWinResultsHolder.getWinResults()).isEqualTo(winResults);
    }

}
