package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {

    @DisplayName("로또 일치 결과 생성 테스트 - 3개 일치")
    @Test
    void createThreeMatch() {
        LottoMatch lottoMatch = LottoMatch.collect(3, false);
        assertThat(lottoMatch).isEqualTo(LottoMatch.THREE_MATCH);
    }

    @DisplayName("로또 일치 결과 생성 테스트 - 5개, 보너스 번호 일치")
    @Test
    void createFiveMatch() {
        LottoMatch lottoMatch = LottoMatch.collect(5, true);
        assertThat(lottoMatch).isEqualTo(LottoMatch.FIVE_AND_BONUS_MATCH);
    }

    @DisplayName("로또 일치 결과 생성 테스트 - 2개 일치")
    @Test
    void createTwoMatch() {
        LottoMatch lottoMatch = LottoMatch.collect(2, false);
        assertThat(lottoMatch).isEqualTo(LottoMatch.NOTHING_MATCH);
    }

    @DisplayName("매칭 결과 확인 테스트")
    @Test
    void getMatching() {
        LottoMatch lottoMatch = LottoMatch.collect(6, false);
        assertThat(lottoMatch.getMatching()).isEqualTo(6);
    }

    @DisplayName("매칭 결과에 알맞는 상금 확인 테스트")
    @Test
    void getAmount() {
        LottoMatch lottoMatch = LottoMatch.collect(5, true);
        assertThat(lottoMatch.getAmount()).isEqualTo(30000000);
    }
}
