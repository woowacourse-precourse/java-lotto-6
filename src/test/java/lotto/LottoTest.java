package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 로또 번호 리스트가 주어지면 Lotto 객체가 생성된다.")
    @Test
    void createLottoByValidNumbers() {
        Assertions.assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(Lotto.class);
    }

    @DisplayName("다양한 번호 일치 경우에 대한 Rank 반환 테스트")
    @ParameterizedTest(name = "번호가 {0}개 일치하고, 보너스 번호가 일치하는 경우 {1}, Rank.{2} 반환")
    @CsvSource({
            "0, false, NONE",
            "3, false, FIFTH",
            "4, false, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND", // 5개의 번호가 일치하고 보너스 번호도 일치함
            "6, false, FIRST"
    })
    void matchRankWithVariousMatches(int matchingNumbers, boolean matchBonus, LottoRank expectedRank) {
        // Given: 유효한 로또 번호 리스트 준비
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // 매칭될 번호와 매칭되지 않을 번호를 설정합니다.
        List<Integer> matchedNumbers = numbers.subList(0, matchingNumbers);
        List<Integer> unmatchedNumbers = List.of(7, 8, 9, 10, 11, 12).subList(0, 6 - matchingNumbers);
        List<Integer> winningNumbersList = new ArrayList<>();
        winningNumbersList.addAll(matchedNumbers);
        winningNumbersList.addAll(unmatchedNumbers);
        WinningNumbers winningNumbers = WinningNumbers.from(winningNumbersList);

        // 보너스 번호 설정
        int bonusNumberValue = 0;
        if (matchBonus) {
            bonusNumberValue = numbers.get(4); // 보너스 번호가 일치해야 하는 경우
        }

        if (!matchBonus) {
            bonusNumberValue = 45; // 보너스 번호가 일치하지 않아야 하는 경우
        }

        BonusNumber bonusNumber = BonusNumber.from(bonusNumberValue);

        // When: Lotto 객체를 생성하고 matchRank 메서드를 호출
        Lotto lotto = new Lotto(numbers);
        LottoRank resultRank = lotto.matchRank(winningNumbers, bonusNumber);

        // Then: 반환된 Rank가 예상 Rank와 일치하는지 검증
        Assertions.assertThat(resultRank).isEqualTo(expectedRank);
    }
}
