package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    //로또 생성 로직: 입력된 조건(로또 번호 범위, 길이 등)에 따라 유효한 로또 번호를 생성하는 로직.
    //당첨 번호와의 비교 로직: 생성된 로또 번호와 당첨 번호를 비교하여 일치하는 번호의 개수를 계산하는 로직.
    //당첨 등수 계산 로직: 일치하는 번호의 개수에 따라 당첨 등수와 상금을 결정하는 로직.
    //수익 계산 로직: 구매한 로또의 수와 당첨 결과에 따라 총 수익을 계산하는 로직.

}