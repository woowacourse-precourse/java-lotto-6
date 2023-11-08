package lotto;

import lotto.controller.inputvalidate.InputValidateAnswer;
import lotto.domain.Lotto;
import lotto.lottoenum.LottoRanking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 정답 번호가 숫자가 아닌 다른 값이 있으면 예외 발생해 빈 List 리턴")
    @Test
    void createLottoByNotNumber(){
        //로또 생성시 Integer List로 받게 구현이 되어 있으므로 입력하는 String을 판별하는 inputValidateAnswer를 사용해
        //예외 발생
        InputValidateAnswer inputValidateAnswer = new InputValidateAnswer();
        Assertions.assertThat(inputValidateAnswer.lottoAnswerValidate("asdf,2,3,4,5,6").isEmpty()).isEqualTo(true);
    }
}