package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class NumberUtilTest {

    @Test
    @DisplayName("랜덤 숫자 생성 성공 케이스")
    void 랜덤_숫자_생성_성공_테스트() {
        List<Integer> numbers = NumberUtil.numberGenerator(1, 45, 6);
        assertThat(numbers.size()).isEqualTo(6);
    }
}