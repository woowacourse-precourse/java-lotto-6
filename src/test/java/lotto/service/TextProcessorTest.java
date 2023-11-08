package lotto.service;

import lotto.exception.ExceptionMessage;
import lotto.model.Lotto;
import lotto.model.LottoTotalPrize;
import lotto.model.constants.LottoWinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TextProcessorTest {
    private TextProcessor textProcessor = new TextProcessor();

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력_미기입_예외_발생")
    void notExistInputAmount(String inputAmount) {
        assertThatThrownBy(
                () -> textProcessor.parsePurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_PURCHASE_AMOUNT.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {", , , , ,", ",2,3,4,5,6", "1, 2, 3, ,5 ,6"})
    @DisplayName("당첨_로또_번호_미기입_예외_발생")
    void notExistInputWinningNumbers(String inputWinningNumbers) {
        assertThatThrownBy(
                () -> textProcessor.splitWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_WINNING_NUMBER.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("당첨_로또_보너스_번호_미기입_예외_발생")
    void notExistInputWinningBonusNumbers(String inputWinningBonusNumbers) {
        assertThatThrownBy(
                () -> textProcessor.parseBonusNumber(inputWinningBonusNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_BONUS_NUMBER.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,육", "1j,2,3,4,5,6", "1a, 22, 3c, 4i,5 ,6"})
    @DisplayName("잘못된_당첨_로또_번호_정수_변환_예외_발생")
    void inValidInputWinningNumbers(String inputWinningNumbers) {
        assertThatThrownBy(
                () -> textProcessor.splitWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INTEGER_FORMAT.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"4j", "7c", "구"})
    @DisplayName("잘못된_당첨_로또_보너스_번호_정수_변환_예외_발생")
    void inValidInputWinningBonusNumbers(String inputWinningBonusNumbers) {
        assertThatThrownBy(
                () -> textProcessor.parseBonusNumber(inputWinningBonusNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_INTEGER_FORMAT.getErrorMessage());
    }

    @Test
    @DisplayName("로또_번호_내역_문자열_반환")
    void lottoAsString() {
        Lotto lotto = Mockito.mock(Lotto.class);
        String result = "[1, 2, 3, 4, 5, 6]";

        Mockito.when(lotto.getNumbers()).thenReturn(List.of(1, 2, 3, 4, 5, 6));

        assertThat(textProcessor.generateLottoNumbersText(lotto))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("로또_당첨_내역_문자열_반환")
    void lottoPrizeAsString() {
        LottoTotalPrize totalPrize = new LottoTotalPrize();
        totalPrize.prizeCountPlus(LottoWinningRank.FIFTH);
        totalPrize.prizeCountPlus(LottoWinningRank.FIFTH);
        totalPrize.prizeCountPlus(LottoWinningRank.THIRD);
        totalPrize.prizeCountPlus(LottoWinningRank.SECOND);

        String result = "3개 일치 (5,000원) - 2개\n" + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 1개\n" + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 0개";

        assertThat(textProcessor.generateLottoResult(totalPrize))
                .isEqualTo(result);
    }
}
