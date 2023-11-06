package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoBonusNumberTest {

    @Test
    public void LottoBonusNumberCreate_를_생성할_수_있다() throws Exception {
        // given
        LottoWinningNumberCreate lottoWinningNumberCreate = new LottoWinningNumberCreate(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        // then
        Assertions.assertThatCode(() -> {
            new LottoBonusNumber(lottoWinningNumberCreate, bonusNumber);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 범위_미만의_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        LottoWinningNumberCreate lottoWinningNumberCreate = new LottoWinningNumberCreate(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = LottoConstant.LOTTO_START_NUMBER - 1;

        // when
        // then
        Assertions.assertThatThrownBy(() -> {
            new LottoBonusNumber(lottoWinningNumberCreate, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 범위_초과의_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        LottoWinningNumberCreate lottoWinningNumberCreate = new LottoWinningNumberCreate(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = LottoConstant.LOTTO_END_NUMBER + 1;

        // when
        // then
        Assertions.assertThatThrownBy(() -> {
            new LottoBonusNumber(lottoWinningNumberCreate, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호와_중복된_보너스_번호로_LottoBonusNumberCreate_생성_시_예외가_발생한다() throws Exception {
        // given
        LottoWinningNumberCreate lottoWinningNumberCreate = new LottoWinningNumberCreate(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        // when
        // then
        Assertions.assertThatThrownBy(() -> {
            new LottoBonusNumber(lottoWinningNumberCreate, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}