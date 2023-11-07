package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class MakeLottosTest {
    private int PURCHACE_NUM = 7;
    private int LOTTO_NUM = 6;

    @DisplayName("구입한 개수만큼 로또를 뽑는다.")
    @Test
    void createRandomLottoNums() {
        List<List<Integer>> makeRandomNums = new MakeLottos().makeLotto(PURCHACE_NUM);
        assertThat(makeRandomNums.size()).isEqualTo(PURCHACE_NUM);
    }
}
