package lotto.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoBonusNumberCreateRequestTest {

    @Test
    public void LottoBonusNumberCreateRequest_를_생성할_수_있다() throws Exception {
        // given
        String bonusNumber = "1";

        // when
        // then
        Assertions.assertThatCode(() -> {
            new LottoBonusNumberCreateRequest(bonusNumber);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 숫자_형식이_아닌_보너스_번호로_LottoBonusNumberCreateRequest_생성_시_예외가_발생한다() throws Exception {
        // given
        String bonusNumber = "a";

        // when
        // then
        Assertions.assertThatThrownBy(() -> {
            new LottoBonusNumberCreateRequest(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}