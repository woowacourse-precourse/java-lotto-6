package lotto.dto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoPurchaseRequestTest {

    @Test
    public void 숫자_형식의_문자열로_LottoPurchaseRequest_를_생성할_수_있다() throws Exception {
        // given
        String purchaseAmount = "10";

        // when
        // then
        Assertions.assertThatCode(() -> {
            new LottoPurchaseRequest(purchaseAmount);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 숫자_형식의_문자열이_아니면_LottoPurchaseRequest_생성_시_예외가_발생한다() throws Exception {
        // given
        String purchaseAmount = "10개";

        // when
        // then
        Assertions.assertThatThrownBy(() -> {
            new LottoPurchaseRequest(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}