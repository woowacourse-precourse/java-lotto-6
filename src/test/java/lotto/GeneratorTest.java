package lotto;

import lotto.generator.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class GeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("입력 개수에 따라 같은 수의 로또 생성")
    @Test
    void buyLottos(){
        assertThat(lottoGenerator.buyLottos(8).size()).isEqualTo(8);
    }
}
