package lotto.collaboration.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoStoreMessageTest {

    @Test
    void get으로_메시지얻을수있다() {
        String expected = "원 단위로 입력해 주세요";

        String actual = LottoStoreMessage.EXCEPTION_INDIVISIBLE.get();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void makeMessageForIndivisible로_단위불가분_경고메시지획득할수있다() {
        String expected = "50원 단위로 입력해 주세요";

        String actual = LottoStoreMessage.makeMessageForIndivisible(50);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void makeMessageForOutOfRange_단위벗어남_경고메시지획득할수있다() {
        String expected = "로또 구매 금액은 10원에서 500원까지만 가능합니다.";

        String actual = LottoStoreMessage.makeMessageForOutOfRange(10, 500);

        assertThat(actual).isEqualTo(expected);
    }

}