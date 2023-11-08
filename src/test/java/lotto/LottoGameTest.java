package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @DisplayName("당첨 번호가 6개일 때 정상 처리")
    @Test
    void inputLottoNumbers_Success() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        lottoGame.inputLottoNumbers(winningNumbers);
    }

    @DisplayName("당첨 번호가 6개가 아닐 때 예외 처리")
    @Test
    void inputLottoNumbers_WrongSize() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> lottoGame.inputLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 숫자를 입력하세요");
    }

    @DisplayName("당첨 번호가 6개가 아닐 때 예외 처리")
    @Test
    void inputLottoNumbers_WrongRange() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> lottoGame.inputLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("올바른 당첨 결과가 매핑되는지 검증_ 3개 일치")
    @Test
    void checkPrizeNumber_CorrectMapping() {
        int count = 0;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9)); // 3개 일치

        for (Integer winningNumber : winningNumbers) {
            if(lotto.getNumbers().contains(winningNumber)) {
                count++;
            }
        }
        assertThat(count).isEqualTo(3);
    }
}