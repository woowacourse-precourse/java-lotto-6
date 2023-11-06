package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest
    @DisplayName("요청 갯수 만큼 로또 번호 생성 테스트")
    @ValueSource(ints = {1, 5, 10, 23})
    void createLottoNumberRangeCheckTest(int quantity) {
        List<Lotto> createdlottoes = lottoMachine.getPurchaseLottoes(quantity);

        Assertions.assertThat(createdlottoes.size()).isEqualTo(quantity);
    }
}