package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("로또 번호와 당첨 번호 매칭 테스트")
    @Test
    void testMatchBylottoNumbersAndWinningNumbers() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);

        int matchResult = LottoResult.matchResult(lottoNumbers, winningNumbers);

        assertThat(5).isEqualTo(matchResult);
    }

}
