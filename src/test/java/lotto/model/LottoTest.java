package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.view.message.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.LOTTO_NUMBER_OVERSIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.LOTTO_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoByOverBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("로또 번호가 서로 다른 6자리 숫자이면 Lotto가 생성된다.")
    @Test
    public void 유효한_로또_생성_테스트() {
        //given
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto createdLotto = new Lotto(lottoNumber);

        //then
        assertThat(createdLotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}