package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("당첨 번호 매칭 갯수를 올바르게 계산하는지 확인한다.")
    @Test
    public void testCountMatchingNumbers() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = List.of(3, 4, 5, 6, 7, 8);

        int matchingCount = lotto.countMatchingNumbers(winningNumbers);

        assertEquals(4, matchingCount);
    }

    @DisplayName("보너스 번호 매칭 여부를 올바르게 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"7:0", "6:1"}, delimiter = ':')
    public void testCountMatchingBonusNumber(int bonusNumber, int expected) {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        int bonusMatchCount = lotto.countMatchingBonusNumber(bonusNumber);
        assertEquals(expected, bonusMatchCount);
    }
}