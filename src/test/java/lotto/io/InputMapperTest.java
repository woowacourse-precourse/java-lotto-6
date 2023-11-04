package lotto.io;

import lotto.domain.LottoPurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 변환 객체에 대해")
class InputMapperTest {

    private final InputMapper inputMapper = new InputMapper();

    @Test
    @DisplayName("LottoPurchasePrice 객체로 변환하여 로또 개수를 가진다.")
    void Given_LottoPurchasePrice_When_getLottosAmount_Then_EqualAmount() {
        //given
        LottoPurchasePrice lottoPurchasePrice = inputMapper.toLottoPurchasePrice("2000");

        //when
        Integer lottosAmount = lottoPurchasePrice.getLottosAmount();

        //then
        assertThat(lottosAmount).isEqualTo(2);
    }
}
