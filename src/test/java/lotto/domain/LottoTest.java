package lotto.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("정상적으로 로또를 생성한다.")
    @Test
    void createValidLotto() {
        // given
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6));

        // when
        ThrowingCallable actual = () -> new Lotto(lottoNumbers);

        // then
        assertThatCode(actual).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // given
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7));

        // when, then
        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // given
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1),
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(5));

        // when, then
        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 5개 이하이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        // given
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5));

        // when, then
        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 몇게 매치되는지 확인한다.")
    @Test
    public void lottoMatchCount() {
        // given
        List<LottoNumber> compareNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(17));

        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);

        // when
        int matchCnt = lotto.matchWinningNumberCount(compareNumbers);

        // then
        assertThat(matchCnt).isEqualTo(5);
    }

    @DisplayName("보너스 번호가 매치되는것을 확인한다.")
    @Test
    public void bonusNumberMatchTrue() {
        // given
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);

        // when
        boolean match = lotto.isMatchBonusNumber(new LottoNumber(1));

        // then
        assertThat(match).isTrue();
    }

    @DisplayName("보너스 번호가 매치되지 않는것을 확인한다.")
    @Test
    public void bonusNumberMatchFalse() {
        // given
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);

        // when
        boolean match = lotto.isMatchBonusNumber(new LottoNumber(7));

        // then
        assertThat(match).isFalse();
    }
}
