package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
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
    @DisplayName("로또와 당첨번호를 비교해 맞힌 개수를 반환하는지 검증한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,7:5",
            "1,2,3,4,5,8:5",
            "1,2,3,4,7,8:4",
            "1,2,3,7,8,9:3"
    },delimiter = ':')
    void checkMatchingNumbersTest(String inputWinningNumbers,int expectedMatchingCount) {
        // 로또 생성
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        // @CsvSource로 당첨번호를 각 케이스 별로 입력받는다.
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

        // checkMatchingNumbers 메서드로 당첨 번호와 일치하는 개수를 구해 검증
        int matchingCount = lotto.checkMatchingNumbers(winningNumbers);
        assertThat(matchingCount).isEqualTo(expectedMatchingCount);
    }
}