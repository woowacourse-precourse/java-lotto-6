package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.domain.GenerateLottoNumber;
import org.junit.jupiter.api.Test;

public class GenerateLottoNumberTest extends NsTest {

    @Test
    void 로또_번호_범위_테스트() {
        GenerateLottoNumber.generate().forEach(number -> assertThat(number).isBetween(1, 45));

        }
    @Test
    void 다른_로또_번호() {
            assertThat(GenerateLottoNumber.generate()).isNotEqualTo(GenerateLottoNumber.generate());
        }

    @Test
    void 로또_번호_생성() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run();
                    assertThat(GenerateLottoNumber.generate()).isEqualTo(List.of(5, 6, 7, 8, 9, 10));
                },
                List.of(5, 6, 7, 8, 9, 10)
        );
    }

    @Override
    protected void runMain() {
        GenerateLottoNumber.generate();
    }
}
