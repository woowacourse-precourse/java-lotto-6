package lotto;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
public class ResultTest {
    @DisplayName("당첨 번호가 모두 일치하는 경우 1등이다.")
    @Test
    void calculateResultWithFirstPrize() {
        List<Lotto> lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<String, Object> result = Result.calculateResult(lottoTickets, winningNumbers, bonusNumber);

        assertThat(result.get("1등")).isEqualTo(1);
        assertThat(result.get("2등")).isEqualTo(0);
        assertThat(result.get("3등")).isEqualTo(0);
        assertThat(result.get("4등")).isEqualTo(0);
        assertThat(result.get("5등")).isEqualTo(0);
        assertThat(result.get("총 수익률")).isEqualTo(0.0);
    }

}