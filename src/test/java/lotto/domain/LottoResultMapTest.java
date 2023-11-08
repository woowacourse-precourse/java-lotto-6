package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultMapTest {

    public static LottoResultMap lottoResultMap;

    @BeforeAll
    static void setup() {
        Map<LottoResult, Integer> lottoResultIntegerMap = new HashMap<>();

        lottoResultIntegerMap.put(LottoResult.FIRST, 1);
        lottoResultIntegerMap.put(LottoResult.SECOND, 1);
        lottoResultIntegerMap.put(LottoResult.THIRD, 1);
        lottoResultIntegerMap.put(LottoResult.FIFTH, 1);
        lottoResultIntegerMap.put(LottoResult.NONE, 2);

        lottoResultMap = new LottoResultMap(lottoResultIntegerMap);
    }

    @DisplayName("결과 개수에 따른 반환 테스트")
    @Test
    void testToString() {
        String expected = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n" +
                "총 수익률은 33858416.7%입니다.";

        assertThat(lottoResultMap.toString())
                .isEqualToNormalizingWhitespace(expected);
    }
}