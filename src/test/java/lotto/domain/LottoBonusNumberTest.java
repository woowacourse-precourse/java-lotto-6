package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.LottoConstant;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoBonusNumberTest {

    @Test
    public void LottoBonusNumberCreate_를_생성할_수_있다() throws Exception {
        // given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        // then
        assertThatCode(() -> {
            new LottoBonusNumber(lottoWinningNumber, bonusNumber);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 범위_미만의_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = LottoConstant.LOTTO_START_NUMBER - 1;

        // when
        // then
        assertThatThrownBy(() -> {
            new LottoBonusNumber(lottoWinningNumber, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 범위_초과의_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = LottoConstant.LOTTO_END_NUMBER + 1;

        // when
        // then
        assertThatThrownBy(() -> {
            new LottoBonusNumber(lottoWinningNumber, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호와_중복된_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        // when
        // then
        assertThatThrownBy(() -> {
            new LottoBonusNumber(lottoWinningNumber, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void matches_호출_시_보너스_번호가_일치_하면_true_를_반환한다() throws Exception {
        // given
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6)),
                7);

        // when
        boolean matches = lottoBonusNumber.matches(7);

        //then
        assertThat(matches).isEqualTo(true);

    }


    @Test
    public void matches_호출_시_보너스_번호가_일치_하지_않으면_false_를_반환한다() throws Exception {
        // given
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6)),
                7);

        // when
        boolean matches = lottoBonusNumber.matches(8);

        //then
        assertThat(matches).isEqualTo(false);

    }
}