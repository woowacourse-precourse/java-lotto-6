package lotto.core;

import lotto.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class RandomTest {
    @DisplayName("오름차순 정렬 확인")
    @Test
    void 무작위_생성_숫자열_오름차순_확인() {
        List<Integer> numbers = Random.getRandomNumbers();

        assertSimpleTest(() ->
                assertThatCode(() -> Validator.validateAscending(numbers))
                        .doesNotThrowAnyException()
        );
    }
}
