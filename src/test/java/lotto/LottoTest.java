package lotto;

import lotto.enums.LottoPrizeConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 당첨 갯수에 따라 다른 LottoPrizeConstants 를 얻는다.")
    @Test
    void testValidCheckPrize() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 6, 7, 8));

        assertThat(lotto.checkPrize(winningNumbers, 9))
                .isEqualTo(LottoPrizeConstants.FOUR_MATCH_PRIZE);

    }

    // 아래에 추가 테스트 작성 가능
}