package lotto.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilTest {
    static class 정렬_확인 extends NsTest {

        @Test
        @DisplayName("랜덤으로 생성한 값이 정렬되어 나오는지 확인")
        void 랜덤_데이터_정렬_확인() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run();
                    },
                    List.of(43, 21, 8, 42, 23, 41)
            );
        }

        @Override
        protected void runMain() {
            List<Integer> randNumbers = RandomUtil.createLottoNumber();
            assertThat(randNumbers).isEqualTo(List.of(8, 21, 23, 41, 42, 43));
        }
    }
}