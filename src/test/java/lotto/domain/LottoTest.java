package lotto.domain;

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 현재 로또가 6개의 숫자를 포함하고 있지 않습니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또에 중복된 숫자가 포함되어 있습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("로또에 1부터 45사이가 아닌 숫자가 포함되어 있다면 예외가 발생한다.")
    public void createLottoByNumberRange() throws Exception {
        //then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 55, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자만 포함되어야 합니다.");
    }

    @Test
    @DisplayName("발행된 로또의 숫자를 조회한다.")
    public void getLottoNumberTest() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 5));

        // when


        // then
        assertThat(lotto.getLotto()).isEqualTo(List.of(1, 2, 3, 4, 9, 5).toString());


    }
}