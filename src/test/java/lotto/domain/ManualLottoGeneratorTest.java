package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottoGeneratorTest {

    @DisplayName("수동으로 로또 번호를 입력하면 해당 번호로 로또가 생성된다.")
    @Test
    void generateTest() {
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lottos generated = manualLottoGenerator.generate(List.of(new Lotto(numbers)));
        List<Lotto> lottos = generated.getLottos();
        assertThat(lottos.size()).isEqualTo(1);
        List<LottoNumber> lottoNumbers = lottos.get(0).getNumbers();
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(numbers).contains(lottoNumber.getNumber());
        }
    }
}
