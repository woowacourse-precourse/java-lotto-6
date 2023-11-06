package lotto;


import java.util.List;
import lotto.output.GeneratedLottoOutput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private static final Integer LOTTONUMBER = 3;

    LottoGenerator generator = new LottoGenerator(LOTTONUMBER);

    @Test
    @DisplayName("로또 번호 6개 확인")
    void generateNumbersTest() {
        List<Integer> numbers = generator.generateNumbers();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("구매 금액 만큼 로또 번호 생성")
    void generateLottos() {
        List<Lotto> lottos = generator.generateLottos();
        GeneratedLottoOutput outputView = new GeneratedLottoOutput(lottos);
        outputView.printGeneratedLottos();
        Assertions.assertThat(lottos.size()).isEqualTo(LOTTONUMBER);
    }


}