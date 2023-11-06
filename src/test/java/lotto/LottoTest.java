package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// domain 패키지 밑에 있는 것이 자연스럽지만 LottoTest의 패키지 이동에 대한 설명이 없으므로 그대로 두었습니다.
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 가진 번호들을 오름차순 정렬, 쉼표로 구분, 대괄호로 감싼 뒤 반환한다.")
    @Test
    void getLottoPrintFormat() {
        // given
        Lotto lotto = new Lotto(List.of(35, 20, 9, 8, 13, 5));
        // when
        String lottoPrintFormat = lotto.toString();
        // then
        assertThat(lottoPrintFormat).isEqualTo("[5, 8, 9, 13, 20, 35]");
    }
}