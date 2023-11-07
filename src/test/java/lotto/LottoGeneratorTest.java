package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("랜덤으로 생성한 숫자가 6개이며 오름차순이어야 한다")
    @Test
    void randomGenerateNumberIsAscend() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();

        //when
        List<Integer> numbers = lottoGenerator.createRandomNumbersByAscending();

        //then
        assertThat(numbers)
                .hasSize(6)
                .isSortedAccordingTo(Comparator.naturalOrder());
    }

    @DisplayName("숫자6개를 전달하면 로또 하나를 발급해야 한다")
    @Test
    void createLottoWhenGivenNumberCount6() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.createOnlyOneLotto(stubNumbers()))
                .isInstanceOf(Lotto.class);
    }

    @DisplayName("발행 개수를 전달하면 정상적으로 로또를 생성해야 한다.")
    @Test
    void createLottoBundleWhenCountPassing() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = lottoGenerator.createLottoBundle(10);

        assertThat(lottos.getSize())
                .isEqualTo(10);

        for (Lotto lotto : lottos.lottoBundle()) {
            assertThat(lotto.getNumbers())
                    .hasSize(6)
                    .isSortedAccordingTo(Comparator.naturalOrder());
        }

    }

    private List<Integer> stubNumbers() {
        return List.of(1, 10, 20, 30, 40, 43);
    }
}
