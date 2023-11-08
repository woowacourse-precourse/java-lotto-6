package lotto.domain;

import lotto.system.Constant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class UserLottoTest {

    @DisplayName("size 메서드 테스트")
    @Nested
    class Size {
        @ParameterizedTest(name = "{0}이 입력으로 들어왔을 때")
        @CsvSource(value = {"8000, 8", "1000, 1", "0, 0", "2000, 2"})
        void 로또_개수를_잘_반환하는지_테스트(int target, int expected) {
            int lottoNum = target / Constant.MONEY_UNIT;
            UserLotto userLotto = new UserLotto(lottoNum);

            assertThat(userLotto.size()).isEqualTo(expected);
        }
    }

    @DisplayName("getLottoAt 메소드 테스트")
    @Nested
    class GetLottoAt {
        @ParameterizedTest(name = "{0}이 입력으로 들어왔을 때")
        @CsvSource(value = {"8000, 8", "1000, 1", "15000, 15", "2000, 2"})
        void 로또객체를_잘_가져오는지_테스트(int target, int size) {
            int lottoNum = target / Constant.MONEY_UNIT;
            UserLotto userLotto = new UserLotto(lottoNum);

            Assertions.assertAll(() -> {
                for (int i = 0; i < size; i++) {
                    assertThat(userLotto.getIndexAt(i)).isInstanceOf(Lotto.class);
                }
            });
        }
    }

}