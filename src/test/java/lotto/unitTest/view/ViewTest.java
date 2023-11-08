package lotto.unitTest.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.IO.Input;
import lotto.model.RankingManager;
import lotto.rule.LottoWinningRule;
import lotto.view.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ViewTest {
    private View view;
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;


    @BeforeEach
    public void setUp() {
        view = new View(new Input());

        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void restoreSettings() {
        Console.close();
        System.setOut(standardOut);
    }

    private void inputValue(String value) {
        System.setIn(new ByteArrayInputStream(value.getBytes()));
    }

    private String getOutput() {
        return outputStreamCaptor.toString();
    }
    @Nested
    class 로또_구입_금액_입력_시 {

        @ParameterizedTest
        @ValueSource(strings = {" ", "\n", "\r", "\t"})
        void 비었거나_공백이면_예외를_발생시킨다(String userInputLottoCost) {
            inputValue(userInputLottoCost);

            assertThatThrownBy(view::inputLottoCost)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1.23", "1 23", "-1000", "테스트"})
        void 숫자_이외의_문자면_예외를_발생시킨다(String userInputLottoCost) {
            inputValue(userInputLottoCost);

            assertThatThrownBy(view::inputLottoCost)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 당첨번호_입력_시 {

        @ParameterizedTest
        @ValueSource(strings = {" ", "\n", "\r", "\t"})
        void 비었거나_공백이면_예외를_발생시킨다(String inputWinningNumbers) {
            inputValue(inputWinningNumbers);

            assertThatThrownBy(view::inputWinningNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 보너스_번호_입력_시 {

        @ParameterizedTest
        @ValueSource(strings = {" ", "\n", "\r", "\t"})
        void 비었거나_공백이면_예외를_발생시킨다(String userInputLottoCost) {
            inputValue(userInputLottoCost);

            assertThatThrownBy(view::inputBonusNumber)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1.23", "1 23", "-1000", "테스트"})
        void 숫자_이외의_문자면_예외를_발생시킨다(String userInputLottoCost) {
            inputValue(userInputLottoCost);

            assertThatThrownBy(view::inputBonusNumber)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"[1,2,3,4,5,6]", "[1,2,3,4,5,6]:[10,11,12,13,14,15]"})
    void 발행된_로또를_출력하는지_확인한다(String shownLottoNumbers) {
        List<String> publishedLotto = List.of(shownLottoNumbers.split(":"));

        view.outputPublishedLotto(publishedLotto);

        assertThat(getOutput()).contains(publishedLotto);
    }

    @Test
    void 당첨_내역을_출력하는지_확인한다() {
        RankingManager rankingManager = mock(RankingManager.class);
        Map<LottoWinningRule, Integer> winningDetails = new LinkedHashMap<>() {{
            put(LottoWinningRule.RANK_FIVE, 1);
            put(LottoWinningRule.RANK_FOUR, 2);
            put(LottoWinningRule.RANK_THREE, 3);
            put(LottoWinningRule.RANK_TWO, 4);
            put(LottoWinningRule.RANK_ONE, 5);
        }};
        when(rankingManager.getWinningDetails()).thenReturn(winningDetails);

        view.outputWinningDetails(rankingManager.getWinningDetails());

        assertThat(getOutput()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 2개",
                "5개 일치 (1,500,000원) - 3개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 4개",
                "6개 일치 (2,000,000,000원) - 5개"
        );
    }

    @Test
    void 총_수익률을_출력하는지_확인한다() {
        String earningsRate = "99.9";
        String outputEarningsRate = String.format("총 수익률은 %s%%입니다.", earningsRate);

        view.outputEarningsRate(earningsRate);

        assertThat(getOutput()).contains(outputEarningsRate);
    }
}