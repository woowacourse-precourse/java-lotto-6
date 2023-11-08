package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @DisplayName("랜덤으로 생성된 로또 번호가 6개인지 확인한다.")
    @RepeatedTest(1000)
    void generateLottoNumbersShouldReturnSizeSix() {
        // given
        // when
        LottoService lottoService = new LottoService();
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        // then
        assertThat(lottoNumbers.size()).isEqualTo(Constant.SIZE_OF_LOTTO_NUMBERS.getValue());
    }

    @DisplayName("랜덤으로 생성된 로또 번호가 1부터 45 사이의 숫자인지 확인한다.")
    @RepeatedTest(1000)
    void generateLottoNumbersShouldReturnNumbersInRange() {
        // given
        // when
        LottoService lottoService = new LottoService();
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        // then
        assertThat(lottoNumbers).allMatch(number -> number >= Constant.MINIMUM_LOTTO_NUMBER.getValue()
                && number <= Constant.MAXIMUM_LOTTO_NUMBER.getValue());
    }

    @DisplayName("랜덤으로 생성된 로또 번호가 중복되지 않는지 확인한다.")
    @RepeatedTest(1000)
    void generateLottoNumbersShouldReturnUniqueNumbers() {
        // given
        // when
        LottoService lottoService = new LottoService();
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        // then
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @DisplayName("로또 구입 금액으로 14000원을 입력하면 14개의 로또를 생성하는지 확인한다.")
    @Test
    void purchaseLottoTicketsShouldReturnLottoTickets() {
        // given
        final int PURCHASE_AMOUNT = 14000;
        final int EXPECTED_LOTTO_TICKETS_SIZE = PURCHASE_AMOUNT / Constant.LOTTO_PRICE.getValue();
        // when
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.purchaseLottoTickets(PURCHASE_AMOUNT);
        // then
        assertThat(lottos.size()).isEqualTo(EXPECTED_LOTTO_TICKETS_SIZE);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외를 발생한다.")
    @Test
    void purchaseLottoTicketsShouldThrowException() {
        // given
        final int PURCHASE_AMOUNT = 14001;
        // when
        LottoService lottoService = new LottoService();
        // then
        assertThatThrownBy(() -> lottoService.purchaseLottoTickets(PURCHASE_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_PURCHASE_AMOUNT_INVALID_UNIT.getMessage());
    }

    @DisplayName("로또 구입 금액이 0원 이하이면 예외를 발생한다.")
    @Test
    void purchaseLottoTicketsShouldThrowExceptionWhenAmountIsZeroAndUnder() {
        // given
        final int PURCHASE_AMOUNT = 0;
        // when
        LottoService lottoService = new LottoService();
        // then
        assertThatThrownBy(() -> lottoService.purchaseLottoTickets(PURCHASE_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM.getMessage());
    }
}