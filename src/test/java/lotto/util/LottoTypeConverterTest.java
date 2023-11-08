package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTypeConverterTest {

    @Test
    void toArray() {
        String[] strings = LottoTypeConverter.toArray("a,b,c");
        assertThat(strings).contains("a","b","c");
    }

    @Test
    void toList() {
        String[] strings = LottoTypeConverter.toArray("a,b,c");
        String[] ints = LottoTypeConverter.toArray("1,2,3");

        List<Integer> list = LottoTypeConverter.toList(ints);

        assertThatThrownBy(() -> LottoTypeConverter.toList(strings))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(list).contains(1,2,3);

    }

    @Test
    void toWon() {
        String money = LottoTypeConverter.toWon(2_000_000_000);
        assertThat(money).isEqualTo(" (2,000,000,000원)");
    }

    @Test
    void percent() {
        String percent = LottoTypeConverter.percent(123_456.7);
        assertThat(percent).isEqualTo("123,456.7");
    }
}