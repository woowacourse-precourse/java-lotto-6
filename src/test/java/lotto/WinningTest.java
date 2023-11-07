package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTest {

    @DisplayName("일치하는 로또 번호의 개수를 찾는다.")
    @Test
    void findNumberOfMatchingLottoNumbers() {
        Application application = new Application();

        List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLotto = List.of(1, 2, 3, 8, 9);

        int matchingCount = application.findNumberOfMatchingLottoNumbers(userLotto, winningLotto);

        assertThat(matchingCount).isEqualTo(3);
    }

    @DisplayName("보너스 볼과 일치하는 수를 가지고 있는지 확인한다.")
    @Test
    void checkMatchingWithBonusNumber() {
        Application application = new Application();

        List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        boolean result = application.isMatchingWithBonusNumber(userLotto, bonusNumber);

        assertThat(result).isEqualTo(true);
    }
}
