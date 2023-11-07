package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("로또 번호와 당첨 번호가 몇 개 중복되는지 확인 - 중복이 있는 경우")
    void matchExist() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Collections.sort(lottoNumbers);

        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 3, 5, 7, 9, 11));
        Collections.sort(winningNumbers);

        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers);

        assertThat(winningNumbersObj.match(lotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 몇 개 중복되는지 확인 - 중복이 없는 경우")
    void matchNone() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Collections.sort(lottoNumbers);

        List<Integer> winningNumbers = new ArrayList<>(List.of(7, 8, 9, 10, 11, 12));
        Collections.sort(winningNumbers);

        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers);

        assertThat(winningNumbersObj.match(lotto)).isEqualTo(0);
    }
}