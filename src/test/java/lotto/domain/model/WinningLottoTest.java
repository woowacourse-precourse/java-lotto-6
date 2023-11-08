package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.IllegalArgumentExceptionType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    List<Integer> winningLottoNumbers;
    int winningBonusNumber;
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = List.of(6, 5, 4, 3, 2, 1);
        winningBonusNumber = 7;
        winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), new LottoBonusNumber(winningBonusNumber));
    }

    @DisplayName("보너스_번호_중복_테스트")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(winningLottoNumbers), new LottoBonusNumber(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.WINNING_LOTTO_CONTAINS_BONUS_NUMBER.getMessage());
    }

    @DisplayName("로또_번호_일치_테스트")
    @Test
    void compareLottoMatchCount() {
        Lotto matched0 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        Lotto matched1 = new Lotto(List.of(1, 41, 42, 43, 44, 45));
        Lotto matched2 = new Lotto(List.of(1, 2, 42, 43, 44, 45));
        Lotto matched3 = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Lotto matched4 = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        Lotto matched5 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lotto matched6 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(winningLotto.getMatchCounts(matched0)).isEqualTo(0);
        softAssertions.assertThat(winningLotto.getMatchCounts(matched1)).isEqualTo(1);
        softAssertions.assertThat(winningLotto.getMatchCounts(matched2)).isEqualTo(2);
        softAssertions.assertThat(winningLotto.getMatchCounts(matched3)).isEqualTo(3);
        softAssertions.assertThat(winningLotto.getMatchCounts(matched4)).isEqualTo(4);
        softAssertions.assertThat(winningLotto.getMatchCounts(matched5)).isEqualTo(5);
        softAssertions.assertThat(winningLotto.getMatchCounts(matched6)).isEqualTo(6);

        softAssertions.assertAll();
    }

    @DisplayName("로또_보너스_번호_일치_테스트")
    @Test
    void compareLottoWithBonusNumber() {
        Lotto lottoHasBonus = new Lotto(List.of(40, 41, 42, 7, 44, 45));
        Lotto LottoNotHaveBonus = new Lotto(List.of(40, 41, 42, 43, 44, 45));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(winningLotto.isLottoMatchedWithBonusNumber(lottoHasBonus)).isTrue();
        softAssertions.assertThat(winningLotto.isLottoMatchedWithBonusNumber(LottoNotHaveBonus)).isFalse();

        softAssertions.assertAll();
    }
}