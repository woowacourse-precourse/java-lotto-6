package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DecimalFormat을 학습하기 위한 테스트이다.")
public class DecimalFormatTest {

    @DisplayName("금액 표기를 할 수 있다.")
    @Test
    void canFormatPrize() {
        // given
        int prize = 2000000000;
        DecimalFormat formatter = new DecimalFormat("###,###");

        // when
        String result = formatter.format(prize);

        // then
        assertThat(result).isEqualTo("2,000,000,000");
    }
}
