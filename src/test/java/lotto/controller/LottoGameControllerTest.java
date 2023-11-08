package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.presentation.controller.LottoGameController;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class LottoGameControllerTest {
    private LottoGameController lottoGameController;
    private View view;
    private Referee referee;
    private LottoTicketRepository ticketRepository;

    @BeforeEach
    void setUp() {
        view = Mockito.mock(View.class);
        referee = Mockito.mock(Referee.class);
        ticketRepository = Mockito.mock(LottoTicketRepository.class);
        lottoGameController = new LottoGameController(view, referee, ticketRepository);
    }

    @DisplayName("입력값이 Null이거나 공백으로만 이루어지면 예외가 발생한다.")
    @Test
    public void checkIfBlank() {
        final String emptyString = "";

        assertThatThrownBy(() -> lottoGameController.isNotBlankValue(emptyString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 정수로 변환될 수 없으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "wooteco8"})
    void checkIfNotInteger(String notInteger) {
        assertThatThrownBy(() -> lottoGameController.isNotIntegerValue(notInteger))
                .isInstanceOf(IllegalArgumentException.class);
    }
}