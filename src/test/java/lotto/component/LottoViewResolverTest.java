package lotto.component;

import static lotto.domain.grade.Grade.FIRST;
import static lotto.domain.grade.Grade.NONE;
import static lotto.domain.grade.Grade.SECOND;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import lotto.domain.grade.GradeCount;
import lotto.domain.result.Profit;
import lotto.domain.result.Result;
import lotto.domain.result.Statistics;
import lotto.service.LottoMessagePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoViewResolverTest {


    private LottoMessagePrinter mockPrinter;
    private LottoViewResolver resolver;
    private Result mockResult;
    private Statistics mockStatistics;
    private Profit mockProfit;
    private GradeCount mockGradeCount;

    @BeforeEach
    void setUp() {
        mockPrinter = mock(LottoMessagePrinter.class);
        resolver = LottoViewResolver.of(mockPrinter);
        mockResult = mock(Result.class);
        mockStatistics = mock(Statistics.class);
        mockProfit = mock(Profit.class);
        mockGradeCount = mock(GradeCount.class);
    }


    @Test
    void 결과를_출력한다() {
        // Arrange
        when(mockResult.getStatistics()).thenReturn(mockStatistics);
        when(mockResult.getProfit()).thenReturn(mockProfit);
        when(mockStatistics.getGradeCounts()).thenReturn(Collections.singletonList(mockGradeCount));
        when(mockGradeCount.getGrade()).thenReturn(FIRST);
        when(mockGradeCount.getCount()).thenReturn(1);

        // Act
        resolver.showResult(mockResult);

        // Assert
        verify(mockPrinter).printResult();
        verify(mockPrinter).printStatistics(FIRST, 1);
        verify(mockPrinter).printProfit(anyDouble());
    }

    @Test
    void 통계를_출력한다() {
        // Arrange
        when(mockStatistics.getGradeCounts()).thenReturn(Arrays.asList(mockGradeCount));
        when(mockGradeCount.getGrade()).thenReturn(SECOND);
        when(mockGradeCount.getCount()).thenReturn(2);

        // Act
        resolver.showStatistics(mockStatistics);

        // Assert
        verify(mockPrinter, times(1)).printStatistics(SECOND, 2);
        verify(mockPrinter, never()).printStatistics(eq(NONE), anyInt());
    }

    @Test
    void 수익률을_출력한다() {
        // Arrange
        double expectedProfit = 150.0;
        when(mockProfit.getPercentage()).thenReturn(expectedProfit);

        // Act
        resolver.showProfit(mockProfit);

        // Assert
        verify(mockPrinter).printProfit(expectedProfit);
    }
}