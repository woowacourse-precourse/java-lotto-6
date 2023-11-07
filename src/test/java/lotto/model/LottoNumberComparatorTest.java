package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberComparatorTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setWinningLotto() {
        winningLotto = WinningLotto.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "7");
    }

    @DisplayName("당첨 로또 세팅 테스트")
    @Test
    void init() {
        LottoNumberComparator lottoNumberComparator = LottoNumberComparator.init(winningLotto);
        assertThat(lottoNumberComparator).isEqualTo(LottoNumberComparator.init(winningLotto));
    }

    @DisplayName("사용자 로또와 당첨 로또 비교 테스트 - 6개 일치")
    @Test
    void calculateSixMatch() {
        LottoNumberComparator lottoNumberComparator = LottoNumberComparator.init(winningLotto);
        List<LottoMatch> lottoMatches = lottoNumberComparator.calculateMatches(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        assertThat(lottoMatches).isEqualTo(List.of(LottoMatch.collect(6, false)));
    }

    @DisplayName("사용자 로또와 당첨 로또 비교 테스트 - 5개, 보너스 번호 일치")
    @Test
    void calculateFiveMatch() {
        LottoNumberComparator lottoNumberComparator = LottoNumberComparator.init(winningLotto);
        List<LottoMatch> lottoMatches2 = lottoNumberComparator.calculateMatches(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        assertThat(lottoMatches2).isEqualTo(List.of(LottoMatch.collect(5, true)));
    }

    @DisplayName("사용자 로또와 당첨 로또 비교 테스트 - 2개 일치")
    @Test
    void calculateTwoMatch() {
        LottoNumberComparator lottoNumberComparator = LottoNumberComparator.init(winningLotto);
        List<LottoMatch> lottoMatches2 = lottoNumberComparator.calculateMatches(List.of(new Lotto(List.of(1, 2, 7, 8, 9, 10))));
        assertThat(lottoMatches2).isEqualTo(List.of(LottoMatch.collect(2, true)));
    }
}
