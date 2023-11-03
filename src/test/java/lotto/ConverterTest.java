package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConverterTest {
    Converter converter = new Converter();
    @Test
    void 구입_금액으로_살_수_있는_로또_수_테스트() {
        int money = 12000;
        int lottoCount = converter.convertMoneyToLottoCount(money);
        assertThat(lottoCount).isEqualTo(12);
    }
}
