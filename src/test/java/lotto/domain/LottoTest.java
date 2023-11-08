package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    @Test
    void 매칭되는_로또번호갯수_반환() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> lottoNumber = new ArrayList<>(List.of(5,6,7,8,9,10));

        // when
        int result = lotto.getMatchNumber(lottoNumber);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 로또번호_존재유무_확인() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int lottoNumber_1 = 6;
        int lottoNumber_2 = 8;

        // when
        boolean result_1 = lotto.isContain(lottoNumber_1);
        boolean result_2 = lotto.isContain(lottoNumber_2);

        // then
        assertThat(result_1).isEqualTo(true);
        assertThat(result_2).isEqualTo(false);
    }
}