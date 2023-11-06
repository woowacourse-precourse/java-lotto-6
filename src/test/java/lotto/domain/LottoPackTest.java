package lotto.domain;

import lotto.util.NumberGenerator.INumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("LottoPack 테스트")
class LottoPackTest {


    @DisplayName("size 테스트")
    @Nested
    class size {

        @DisplayName("생성 시 넣은 숫자만큼의 숫자를 반환한다.")
        @Test
        void sizeReturnsGivenNumbers() {
            LottoPack lottoPack = LottoPack.createLottoPack(10);
            Assertions.assertEquals(lottoPack.size(), 10);
        }

    }

    @DisplayName("toString 테스트")
    @Nested
    class toString {

        @DisplayName("출력 문자열을 확인한다.")
        @Test
        void toStringConventionCheck() {

            LottoPack lottoPack = new LottoPack(
                    1, new FakeNumberGenerator(List.of(1, 2, 3, 4, 5, 6))
            );

            org.assertj.core.api.Assertions.assertThat(lottoPack.toString())
                    .contains("[1, 2, 3, 4, 5, 6]");

        }

    }


}

class FakeNumberGenerator implements INumberGenerator {

    private final List<Integer> list;

    public FakeNumberGenerator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> generateNumbers() {
        return list;
    }

}