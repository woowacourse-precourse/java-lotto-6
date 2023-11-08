package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 갯수 만큼 로또 뭉치를 만든다.")
    void create_lotto_bundle_with_random_service() {
        // given
        LottoMachine lottoMachine = new LottoMachine(
                (startInclusive, endInclusive, count) -> Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        LottoBundle lottoBundle = lottoMachine.createLottoBundle(3);

        // then
        assertThat(lottoBundle).isEqualTo(new LottoBundle(
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                )
        ));
    }
}
