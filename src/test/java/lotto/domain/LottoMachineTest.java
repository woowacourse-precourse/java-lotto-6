package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    LottoMachine lottoMachine = LottoMachine.getInstance();

    @ParameterizedTest
    @DisplayName("요청 갯수 만큼 로또 번호 생성 테스트")
    @ValueSource(ints = {1, 5, 10, 23})
    void createLottoNumberRangeCheckTest(int quantity) {
        List<Lotto> lottos = lottoMachine.createLottos(quantity);

        Assertions.assertThat(lottos.size()).isEqualTo(quantity);
    }

    @Test
    @DisplayName("로또 당첨 번호 비교 테스트")
    void lottoNumberWinningComparisonTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    }
}