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

    @DisplayName("입력값이 Null이거나 공백으로만 이루어지면 예외가 발생한다.")
    @Test
    public void checkIfBlank() {
        final String emptyString = "";

        assertThatThrownBy(() -> mc.isNotBlankValue(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("아무것도 입력하지 않으셨거나, 공백만으로 이뤄진 값이 있습니다.");
    }

    @DisplayName("입력값이 정수로 변환될 수 없으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "wooteco8"})
    void checkIfNotInteger(String notInteger) {
        assertThatThrownBy(() -> mc.isNotIntegerValue(notInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수로 변환 가능한 값을 입력하셔야 합니다.");
    }
}