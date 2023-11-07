package lotto;

import lotto.data.BonusNumber;
import lotto.data.Lotto;
import lotto.data.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testCountMatchNumbers() {

        //당첨 숫자들
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)); // 이 곳에서 정수 리스트를 생성해야 합니다.

        //로또 숫자들
        Lotto lotto = new Lotto(Arrays.asList(45, 2, 3, 4, 5, 6));

        int count = lotto.countMatchNumbers(winningNumbers);

        //5개가 똑같음
        int expectedCount = 5;

        // 예상 결과와 실제 결과를 비교.
        assertEquals(expectedCount, count); // expectedCount에 예상 결과를 대입해야 합니다.
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void testTureIsMatchBonusNumber(int number) {
        //로또 숫자들
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //보너스 수
        BonusNumber bonusNumber = new BonusNumber(number);
        boolean hasBonusNumber = lotto.isMatchBonusNumber(bonusNumber);

        boolean result = true;
        // 예상 결과와 실제 결과를 비교.
        assertEquals(result, hasBonusNumber); // expectedCount에 예상 결과를 대입해야 합니다.
    }

    @ParameterizedTest
    @ValueSource(ints = {11,22,33})
    public void testFalseIsMatchBonusNumber(int number) {
        //로또 숫자들
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //보너스 수
        BonusNumber bonusNumber = new BonusNumber(number);
        boolean hasBonusNumber = lotto.isMatchBonusNumber(bonusNumber);

        boolean result = false;
        // 예상 결과와 실제 결과를 비교.
        assertEquals(result, hasBonusNumber); // expectedCount에 예상 결과를 대입해야 합니다.
    }



}