package lotto.domain;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    @DisplayName("보너스 번호가 로또 번호와 중복된다면 예외가 발생한다.")
    void bonusNumDuplicatedLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 1;

        assertThatThrownBy(() -> lotto.checkBonusNum(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입한 로또 번호와 당첨 번호가 일치하는 수를 반환한다")
    void checkSameNumberTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userNum = IntStream.range(1, 7).boxed().collect(Collectors.toList());
        int bonusNum =7;

        //when
        int result = lotto.checkSameNum(userNum, bonusNum);

        //then
        Assertions.assertThat(result).isEqualTo(6);

    }
}