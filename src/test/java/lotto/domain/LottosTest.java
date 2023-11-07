package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @DisplayName("1에서 45사이의 숫자가 나오지 않으면 예외 발생")
    @Test
    void outBoundRangeLottoNumber(){
        List<Integer> numbers = List.of(1,5,45,6,50,20);
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    assertThatThrownBy(()->new Lottos(1))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                },
                numbers
        );
    }
}
