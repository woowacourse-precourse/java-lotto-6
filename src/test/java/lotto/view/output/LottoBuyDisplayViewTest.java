package lotto.view.output;

import lotto.view.DisplayTestSupport;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoBuyDisplayViewTest extends DisplayTestSupport {

    private LottoBuyOutputView lottoBuyOutputView = new LottoBuyOutputView();

    @Test
    @DisplayName("로또를 몇 개 구매했는지 출력할 수 있다.")
    public void printPurchaseLottoCountMessage() {
        // given
        Lottos lottos = createLottos();
        String result = String.format("%s개를 구매했습니다.", lottos.size());
        // when
        lottoBuyOutputView.printPurchaseLottoCountMessage(lottos);
        // then
        assertThat(result).isEqualTo(output());
    }

    @Test
    @DisplayName("구매한 모든 로또 번호를 출력할 수 있다.")
    public void printAllLottoNumbers() {
        // given
        Lottos lottos = createLottos();
        String result = "[1,2,3,4,5,6]\n" +
                        "[1,2,3,4,5,6]\n\n";
        // when
        lottoBuyOutputView.printAllLottoNumbers(lottos);
        // then
        assertThat(result).isEqualTo(outputNotTrim());
    }

    private Lottos createLottos() {
        Lottos lottos = new Lottos(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        return lottos;
    }

}