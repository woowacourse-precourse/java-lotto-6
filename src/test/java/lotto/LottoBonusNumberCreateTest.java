package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoBonusNumberCreateTest {

    @Test
    public void LottoBonusNumberCreate_를_생성할_수_있다() throws Exception {
        // given
        int bonusNumber = 1;

        // when
        // then
        Assertions.assertThatCode(() -> {
            new LottoBonusNumberCreate(bonusNumber);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 범위_미만의_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        int bonusNumber = LottoConstant.LOTTO_START_NUMBER - 1;

        // when
        // then
        Assertions.assertThatThrownBy(() -> {
            new LottoBonusNumberCreate(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 범위_초과의_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        int bonusNumber = LottoConstant.LOTTO_END_NUMBER + 1;

        // when
        // then
        Assertions.assertThatThrownBy(() -> {
            new LottoBonusNumberCreate(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}