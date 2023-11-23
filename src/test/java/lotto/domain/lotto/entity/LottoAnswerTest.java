package lotto.domain.lotto.entity;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoAnswerTest {

    @Nested
    @DisplayName("객체 생성 테스트")
    class 객체_생성_테스트 {

        @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
        @Test
        void 보너스_번호_중복() {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new LottoAnswer(
                            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                            5
                    ));
        }
    }
}