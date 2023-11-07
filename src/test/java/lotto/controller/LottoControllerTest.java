package lotto.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.domain.result.Grade;
import lotto.service.LottoInputReader;
import lotto.service.LottoOutputWriter;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    void 로또_결과를_출력한다() {
        // Arrange
        LottoInputReader mockInputReader = mock(LottoInputReader.class);
        LottoOutputWriter mockOutputWriter = mock(LottoOutputWriter.class);

        when(mockInputReader.readPurchaseAmount()).thenReturn(8000);
        when(mockInputReader.readWinNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));
        when(mockInputReader.readBonusNumber(anyList())).thenReturn(7);

        LottoController controller = LottoController.of(mockInputReader, mockOutputWriter);

        // Act
        controller.handle();

        // Assert
        verify(mockOutputWriter).showLottos(anyList());
        verify(mockOutputWriter, times(5)).showStatistics(any(Grade.class), anyInt());
        verify(mockOutputWriter).showProfit(anyDouble());
    }
}