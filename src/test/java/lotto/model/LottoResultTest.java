package lotto.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    LottoResult lottoResult;
    WinningInfo winningInfo;

    @BeforeEach
    void setUp() {
        lottoResult = LottoResult.of();
        winningInfo = WinningInfo.THREE_MATCH;
    }

    @DisplayName("addResult로 winningInfo에 대한 count 데이터를 추가할 수 있다.")
    @Test
    void addResultIfNotPresent() {
        lottoResult.addResult(winningInfo);
        assertThat(lottoResult.getCount(winningInfo)).isEqualTo(1);
    }

    @DisplayName("addResult로 winningInfo에 대한 count를 늘릴 수 있다.")
    @Test
    void addResultIncrementCount() {
        lottoResult.addResult(winningInfo);
        lottoResult.addResult(winningInfo);

        assertThat(lottoResult.getCount(winningInfo)).isEqualTo(2);
    }

    @DisplayName("키 값이 존재하지 않을 때 default 값을 반환할 수 있다.")
    @Test
    void getDefaultCount() {
        assertThat(lottoResult.getCount(winningInfo)).isEqualTo(0);
    }

    @DisplayName("키 값이 존재할 때 해당 count 값을 반환할 수 있다.")
    @Test
    void getCount() {
        lottoResult.addResult(winningInfo);

        assertThat(lottoResult.getCount(winningInfo)).isEqualTo(1);
    }


    @DisplayName("calculateWinningAmount는 올바른 금액을 반환할 수 있다.")
    @Test
    void calculateWinningAmountShouldReturnCorrectAmount() {
        lottoResult.addResult(winningInfo);
        assertThat(lottoResult.calculateWinningAmount(winningInfo)).isEqualTo(5000);

        lottoResult.addResult(winningInfo);
        assertThat(lottoResult.calculateWinningAmount(winningInfo)).isEqualTo(10000);
    }

}