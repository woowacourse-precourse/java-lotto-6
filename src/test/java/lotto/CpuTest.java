package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.Model.Cpu;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CpuTest {

    @DisplayName("돈이 천원단위로 투입됐는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1500, 1900, 25010, 19002, 34456, 10004, 6000004})
    void unitMoneyTest(int target) {
        List<Lotto> lottoList = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> new Cpu(target))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
