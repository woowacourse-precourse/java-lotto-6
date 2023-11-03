package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.input.view.GeneratedLottoOutputView;
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
    @DisplayName("로또 번호 생성 값 정렬 확인")
    void generateLottoTest() {
        List<Integer> numbers = generator.generateNumbers();
        List<Integer> compareNumbers = new ArrayList<>(numbers);
        List<Integer> notSortedNumbers = new ArrayList<>(numbers);
        Lotto lotto = generator.generateLotto(numbers);
        Collections.sort(compareNumbers);
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(compareNumbers);
        Assertions.assertThat(lotto.getNumbers()).isNotEqualTo(notSortedNumbers);
    }

    @Test
    @DisplayName("구매 금액 만큼 로또 번호 생성")
    void generateLottos() {
        List<Lotto> lottos = generator.generateLottos();
        GeneratedLottoOutputView outputView = new GeneratedLottoOutputView(lottos);
        outputView.printGeneratedLottos();
        Assertions.assertThat(lottos.size()).isEqualTo(LOTTONUMBER);
    }


}