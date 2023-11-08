package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    @DisplayName("로또 번호가 당첨 번호와 몇 개가 겹치는지 반환한다.")
    @Test
    void 로또_번호_당첨_번호_중복_있음() {
        Lotto lottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> winningNumbers = Arrays.asList(3,4,5,7,6,8);

        int result = lottoNumbers.numOfMatchNum(winningNumbers);

        Assertions.assertThat(result).isEqualTo(4);
    }

    @DisplayName("로또 번호가 당첨 번호와 몇 개가 겹치는지 반환한다.")
    @Test
    void 로또_번호_당첨_번호_중복_없음() {
        Lotto lottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> winningNumbers = Arrays.asList(7,8,9,10,11,12);

        int result = lottoNumbers.numOfMatchNum(winningNumbers);

        Assertions.assertThat(result).isEqualTo(0);
    }

    @DisplayName("보너스 번호가 있으면 true를 반환한다.")
    @Test
    void 로또번호에_보너스_번호_있음() {
        Lotto lottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNum = 5;

        boolean result = lottoNumbers.ifBonusNumEqual(bonusNum);

        Assertions.assertThat(result).isEqualTo(true);
    }

    @DisplayName("보너스 번호가 없으면 false 반환")
    @Test
    void 로또번호에_보너스_번호_없음() {
        Lotto lottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNum = 20;

        boolean result = lottoNumbers.ifBonusNumEqual(bonusNum);

        Assertions.assertThat(result).isEqualTo(false);
    }
}

