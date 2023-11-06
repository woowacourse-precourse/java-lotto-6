package lotto.model;

import static lotto.exception.ExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.ExceptionMessage.NOT_MUST_BE_NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    private static LottoMachine lottoMachine;

    @BeforeAll
    static void beforeAll() {
        lottoMachine = new LottoMachine(() -> List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("금액에 맞춰 로또를 생성한다.")
    void createLottoTickets() throws Exception {
        // given
        final LottoManager lottoManager = new LottoManager(lottoMachine);

        // when
        final List<Lotto> lottoTickets = lottoManager.createLottoTickets(14000);

        // then
        assertThat(lottoTickets).hasSize(14);
    }

    @Test
    @DisplayName("당첨 로또를 생성한다.")
    void createWinningLottoTicket() throws Exception {
        // given
        final List<Integer> winningNumbers = List.of(10, 11, 12, 13, 14, 15);
        final LottoManager lottoManager = new LottoManager(lottoMachine);

        // when
        final Lotto winningLottoTicket = lottoManager.createWinningLottoTicket(winningNumbers);
        final List<Integer> result = winningLottoTicket.getNumbers();

        // then
        assertThat(result).containsExactly(10, 11, 12, 13, 14, 15);
    }

    @Test
    @DisplayName("보너스 번호를 생성한다.")
    void createBonusNumber() throws Exception {
        // given
        final List<Integer> winningNumbers = List.of(10, 11, 12, 13, 14, 15);
        final LottoManager lottoManager = new LottoManager(lottoMachine);
        final Lotto winningLotto = new Lotto(winningNumbers);

        // when
        final int bonusNumber = lottoManager.createBonusNumber(winningLotto, 45);

        // then
        assertThat(bonusNumber).isEqualTo(45);
    }

    @Test
    @DisplayName("보너스 번호 생성 시 당첨 로또가 null이면 예외가 발생한다.")
    void createBonusNumberWinningLottoIsNull() throws Exception {
        // given
        final LottoManager lottoManager = new LottoManager(lottoMachine);

        // when
        // then
        assertThatThrownBy(() -> lottoManager.createBonusNumber(null, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_MUST_BE_NULL.format());
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복이면 예외가 발생한다.")
    void duplicateLottoNumberWhenCreateBonusNumber() throws Exception {
        // given
        final List<Integer> winningNumbers = List.of(10, 11, 12, 13, 14, 15);
        final LottoManager lottoManager = new LottoManager(lottoMachine);
        final Lotto winningLotto = new Lotto(winningNumbers);

        // when
        // then
        assertThatThrownBy(() -> lottoManager.createBonusNumber(winningLotto, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER.format());
    }
}
