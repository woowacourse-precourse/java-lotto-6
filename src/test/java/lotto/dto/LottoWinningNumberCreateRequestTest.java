package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoWinningNumberCreateRequestTest {


    @Test
    public void LottoWinningNumberCreateRequest_를_생성할_수_있다() throws Exception {
        // given
        String numbers = "1,2,3,4,5,6";

        // when
        // then
        assertThatCode(() -> {
            new LottoWinningNumberCreateRequest(numbers);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 입력이_숫자가_아니면_LottoWinningNumberCreateRequest_생성_시_예외가_발생한다() throws Exception {
        // given
        String numbers = "1,2,3,4,5,a";

        // when
        // then
        assertThatThrownBy(() -> {
            new LottoWinningNumberCreateRequest(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}