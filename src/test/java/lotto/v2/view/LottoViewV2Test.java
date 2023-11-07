package lotto.v2.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class LottoViewV2Test {

    @Mock
    private Console console;

    private LottoViewV2 lottoViewV2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoViewV2 = new LottoViewV2(console);
    }

    @Test
    public void testInputMoney_ValidAmount() {
        // Given
        when(console.readLine()).thenReturn("3000");

        // When
        int amount = lottoViewV2.inputMoney();

        // Then
        assertThat(amount).isEqualTo(3000);
    }

}