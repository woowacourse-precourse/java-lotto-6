package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto 클래스")
class WinningLottoTest {

    private WinningLotto winningLotto;
    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setup() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = new BonusNumber(7);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외를 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        BonusNumber duplicatedBonusBonusNumber = new BonusNumber(6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, duplicatedBonusBonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 일치하는 수의 개수를 반환한다.")
    @Test
    void getMatchCount() {
        List<Integer> testNumbers = List.of(1, 2, 3, 7, 8, 9);
        assertThat(winningLotto.getMatchCount(testNumbers)).isEqualTo(3);
    }

    @DisplayName("보너스 번호가 일치하면 참을 반환한다.")
    @Test
    void trueIfBonusNumberIsMatched() {
        List<Integer> testNumbers = List.of(1, 2, 3, 7, 8, 9);
        assertTrue(winningLotto.isBonusMatched(testNumbers));
    }

    @DisplayName("보너스 번호가 일치하지 않으면 거짓을 반환한다.")
    @Test
    void falseIfBonusNumberIsMatched() {
        List<Integer> testNumbers = List.of(1, 2, 3, 6, 8, 9);
        assertFalse(winningLotto.isBonusMatched(testNumbers));
    }
}