package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    static Stream generateData() {
        Stream lottos = Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 45),
                Arrays.asList(10, 21, 35, 42, 7, 3)
        );
        return lottos;
    }

    @DisplayName("6개의 랜덤 숫자가 든 복권을 발행한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    public void issueLotto(List<Integer> randomNumbers) {
        // given & when
        Lotto lotto = lottoMachine.issueLotto(() -> randomNumbers);

        // then
        assertTrue(lotto.getNumbers().size() == 6);
    }


    @DisplayName("복권은 오름차순으로 발행한다.")
    @Test
    public void issuedLottosSort() {
        // given & when
        Lotto lotto = lottoMachine.issueLotto(() -> Arrays.asList(6, 5, 4, 3, 2, 1));

        // then
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
