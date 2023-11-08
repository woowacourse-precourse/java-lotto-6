package lotto;

import Model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto가 개수만큼 올바르게 생성 되는지 확인한다.")
    @Test
    void createLottoTicket() {
        // given
        LottoTicket lottoTicket = new LottoTicket(3);

        // then
        assertEquals(3, lottoTicket.getLottos().size());
    }

    @DisplayName("금액이 1000으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPriceDivide() {
        assertThatThrownBy(() -> new LottoManager(5600))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 올바르게 저장되었는지 확인")
    @Test
    void createLottoAnalyzer() {
        // given
        List<Integer> lottoNumber = List.of(2,3,4,5,6,7);
        List<String> prizeNumber = List.of("2","3","4","5","6","7");
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(prizeNumber, 8);

        // then
        assertEquals(lottoNumber, lottoAnalyzer.getPrizeNumber());
        assertEquals(8, lottoAnalyzer.getBonusNumber());
    }

    @DisplayName("당첨 번호와 동일한 숫자 개수 저장이 올바르게 되는지")
    @Test
    void checkSameNumber() {
        // given
        List<Integer> lottoNumber = List.of(2,3,4,5,6,7);
        List<String> prizeNumber = List.of("2","3","4","5","11","15");
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(prizeNumber, 8);

        // then
        assertEquals(4, lottoAnalyzer.compare(lottoNumber));
    }
}