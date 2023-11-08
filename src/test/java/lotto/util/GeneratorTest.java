package lotto.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.util.Generator.generateNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest extends NsTest{

//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void createLottoByDuplicatedNumber() {
//        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
//        assertThatThrownBy(
//                () ->  generateNumbers()
//        ).isInstanceOf(IllegalArgumentException.class);
//    }

    @DisplayName("로또 번호에 중복된 숫자가 없을 경우 성공!.")
    @Test
    void testLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(generateNumbers()).hasSameClassAs(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
                },
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
    @Override
    public void runMain() {
        generateNumbers();
    }
}
