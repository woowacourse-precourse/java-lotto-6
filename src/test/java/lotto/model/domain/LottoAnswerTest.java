package lotto.model.domain;

import java.util.List;
import lotto.model.domain.lotto.LottoAnswer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAnswerTest {

    @Test
    @DisplayName("정답에 중복된 숫자가 있으면 예외가 발생한다.")
    public void answerNumbersCantDuplicated() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoAnswer(List.of(1, 1, 2, 3, 4, 5), 8));
    }

    @Test
    @DisplayName("보너스 숫자가 정답에 있으면 예외가 발생한다.")
    public void bonusNumbersCantDuplicated() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 6));
    }

    @Test
    @DisplayName("정상적인 정답 생성")
    public void normalAnswerTest() throws Exception{
        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7));
    }


}