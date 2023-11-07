package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        this.lottoResult = new LottoResult();
    }

    @Test
    void addResultIsCorrect() {
        MatchCount matchCount = MatchCount.SIX_MATCH;

        assertThatCode(() -> lottoResult.addResult(matchCount))
            .doesNotThrowAnyException();
    }

    @DisplayName("매칭된 로또 티켓의 기본 장수 정보를 가져오는 데 문제가 없는지")
    @ParameterizedTest
    @EnumSource(MatchCount.class)
    void getMatchedTicketCountIsCorrect(MatchCount matchCount) {
        assertThat(lottoResult.getMatchedTicketCount(matchCount))
            .isEqualTo(Constants.ZERO);
    }


    @DisplayName("수익률이 올바르게 계산 되는지 확인")
    @Test
    void calculateEarningRateIsCorrect() {
        lottoResult.addResult(MatchCount.THREE_MATCH);
        int purchaseAmount = 8000;

        double expectedEarningsRate = 62.5;

        assertThat(lottoResult.calculateEarningsRate(purchaseAmount)).isEqualTo(
            expectedEarningsRate);
    }



}