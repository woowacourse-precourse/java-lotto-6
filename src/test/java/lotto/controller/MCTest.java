package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.presentation.controller.MC;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class MCTest {
    private MC mc;
    private View view;
    private Referee referee;
    private LottoTicketRepository ticketRepository;

    @BeforeEach
    void setUp() {
        view = Mockito.mock(View.class);
        referee = Mockito.mock(Referee.class);
        ticketRepository = Mockito.mock(LottoTicketRepository.class);
        mc = new MC(view, referee, ticketRepository);
    }

    @DisplayName("로또 구입 금액이 Null이거나 공백으로만 이루어지면 예외가 발생한다.")
    @Test
    public void checkIfBlank() {
        final String emptyString = "";

        assertThatThrownBy(() -> mc.isNotBlankValue(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무것도 입력하지 않으셨거나 빈 공백만 입력하셨습니다.");
    }

    @DisplayName("로또 구입 금액으로 받은 입력값이 정수로 변환될 수 없으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "wooteco8"})
    void checkIfNotInteger(String notInteger) {
        assertThatThrownBy(() -> mc.isNotIntegerValue(notInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 정수여야 합니다.");
    }

    @DisplayName("로또 티켓 구입 금액이 1000원 미만이거나 1000원의 배수가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"800", "1200"})
    void checkIfRangeOut(String inputBuyingCost) {
        assertThatThrownBy(() -> mc.isNotMultipleOfLottoPrice(inputBuyingCost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 로또 가격의 배수여야 합니다.");
    }
}