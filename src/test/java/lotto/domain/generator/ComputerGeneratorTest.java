package lotto.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.constant.RangeConstant.*;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerGeneratorTest {

    @DisplayName("컴퓨터가 숫자를 Lotto 조건에 맞는 숫자를 생성하는지 테스트")
    @Test
    void generate() {
        ComputerGenerator computerGenerator = new ComputerGenerator();
        List<Integer> generate = computerGenerator.generate();

        assertThat(generate.size()).isEqualTo(SIZE_NUM.getNumber());
        assertThat(generate.stream().distinct().count()).isEqualTo(SIZE_NUM.getNumber());
        assertThat(generate.stream()
                .filter(i -> i > END_NUM.getNumber()).count()).isEqualTo(0);
        assertThat(generate.stream()
                .filter(i -> i < START_NUM.getNumber()).count()).isEqualTo(0);
    }
}