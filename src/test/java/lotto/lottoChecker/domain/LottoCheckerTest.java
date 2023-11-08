package lotto.lottoChecker.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCheckerTest {

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 당첨 등수를 계산한다. (비당첨)")
    @Test
    void 로또_당첨_등수_계산_비당첨() {
        LottoChecker lottoChecker = new LottoChecker();
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32, 45));
        List<Integer> lottoNumbers = new ArrayList<Integer>(Arrays.asList(3, 5, 6, 7, 8, 16));

        assertThat(lottoChecker.calculateRank(winningNumbers, lottoNumbers)).isEqualTo(6);
    }

    @DisplayName("로또 당첨 등수를 계산한다. (비당첨)")
    @Test
    void 로또_당첨_등수_계산_오등() {
        LottoChecker lottoChecker = new LottoChecker();
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32, 45));
        List<Integer> lottoNumbers = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 16, 32, 45));

        assertThat(lottoChecker.calculateRank(winningNumbers, lottoNumbers)).isEqualTo(5);
    }

    @DisplayName("로또 당첨 등수를 계산한다. (비당첨)")
    @Test
    void 로또_당첨_등수_계산_사등() {
        LottoChecker lottoChecker = new LottoChecker();
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32, 45));
        List<Integer> lottoNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 16, 32, 45));

        assertThat(lottoChecker.calculateRank(winningNumbers, lottoNumbers)).isEqualTo(4);
    }

    @DisplayName("로또 당첨 등수를 계산한다. (비당첨)")
    @Test
    void 로또_당첨_등수_계산_삼등() {
        LottoChecker lottoChecker = new LottoChecker();
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32, 45));
        List<Integer> lottoNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 16, 32, 44));

        assertThat(lottoChecker.calculateRank(winningNumbers, lottoNumbers)).isEqualTo(3);
    }

    @DisplayName("로또 당첨 등수를 계산한다. (비당첨)")
    @Test
    void 로또_당첨_등수_계산_보너스() {
        LottoChecker lottoChecker = new LottoChecker();
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32, 45));
        List<Integer> lottoNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 16, 32, 45));

        assertThat(lottoChecker.calculateRank(winningNumbers, lottoNumbers)).isEqualTo(2);
    }

    @DisplayName("로또 당첨 등수를 계산한다. (비당첨)")
    @Test
    void 로또_당첨_등수_계산_일등() {
        LottoChecker lottoChecker = new LottoChecker();
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32, 45));
        List<Integer> lottoNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32));

        assertThat(lottoChecker.calculateRank(winningNumbers, lottoNumbers)).isEqualTo(1);
    }

}
