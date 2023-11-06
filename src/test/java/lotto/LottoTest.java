package lotto;

import lotto.controller.WinningNumberController;
import lotto.domain.*;
import lotto.domain.constants.ExceptionMessage;
import lotto.util.Calculator;
import lotto.util.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private static final WinningNumbers WINNING_NUMBERS = new WinningNumbers();
    private static final BonusNumber BONUS_NUMBER = new BonusNumber();
    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자는 로또 구입 금액을 입력할 수 있다.")
    @Test
    void createMoneyByInput() {
        assertThat(new Money("3000")).isNotNull();
    }

    @DisplayName("로또 구입 금액을 입력할 때 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void createMoneyByNonNumericalValue() {
        assertThatThrownBy(() -> new Money("AAA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구입 금액을 입력할 때 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNon1000Units() {
        assertThatThrownBy(() -> new Money("30"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_MONEY_NOT_PRICE_UNIT.getMessage());
    }

    @DisplayName("당첨 번호를 입력할 때 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void setWinningNumbersByNonNumericalValue() {
        String playerInput = "A,2,3,4,5,6";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(WINNING_NUMBERS, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호가 1 ~ 45의 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void setWinningNumbersByOutOfRangeNumber() {
        String playerInput = "100,2,3,4,5,6";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(WINNING_NUMBERS, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void setWinningNumbersByOverSize() {
        String playerInput = "1,2,3,4,5,6,7";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(WINNING_NUMBERS, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBERS_COUNT_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 값이 있으면 예외가 발생한다.")
    @Test
    void setWinningNumbersByDuplicateNumber() {
        String playerInput = "1,2,3,3,5,6";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(WINNING_NUMBERS, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBERS_DUPLICATION.getMessage());
    }

    @DisplayName("보너스 번호를 입력할 때 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void setBonusNumberByNonNumericalValue() {
        String playerInput = "A";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() ->
                winningNumberController.setInputToBonusNumber(WINNING_NUMBERS, BONUS_NUMBER, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 1 ~ 45의 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByOutOfRangeNumber() {
        String playerInput = "100";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToBonusNumber(WINNING_NUMBERS, BONUS_NUMBER, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByDuplicateNumber() {
        WINNING_NUMBERS.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        String playerInput = "1";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToBonusNumber(WINNING_NUMBERS, BONUS_NUMBER, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_DUPLICATION_WITH_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("구매한 로또 번호와 당첨 번호를 비교하여 당첨 결과 내역을 얻을 수 있다.")
    @Test
    void calculateWinningStatistics() {
        //given
        List<Integer> expectedStatistics = List.of(1, 1, 1, 1, 1);

        Lottos lottos = new Lottos();
        setStatisticsAndGetTotalProfit(lottos);

        //when
        lottos.calculateWinningStatistics(WINNING_NUMBERS, BONUS_NUMBER);
        List<Integer> actualStatistics = List.of(lottos.getLottoCountByPlace(1), lottos.getLottoCountByPlace(2),
                lottos.getLottoCountByPlace(3), lottos.getLottoCountByPlace(4), lottos.getLottoCountByPlace(5));


        //then
        assertThat(actualStatistics).isEqualTo(expectedStatistics);
    }

    @DisplayName("당첨 결과 내역에 따라 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        //given
        Money inputMoney = new Money("5000");
        Lottos lottos = new Lottos();
        int expectedTotalProfit = setStatisticsAndGetTotalProfit(lottos);
        double expectedProfitRate = (double) expectedTotalProfit / inputMoney.getMoney() * 100;

        //when
        lottos.calculateWinningStatistics(WINNING_NUMBERS, BONUS_NUMBER);
        int actualTotalProfit = lottos.getTotalProfit();
        double actualProfitRate = calculator.getProfitRate(actualTotalProfit, inputMoney.getMoney());

        //then
        assertThat(parser.doubleToFirstDecimalPlace(actualProfitRate))
                .isEqualTo(parser.doubleToFirstDecimalPlace(expectedProfitRate));
    }

    private int setStatisticsAndGetTotalProfit(Lottos lottos) {
        WINNING_NUMBERS.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BONUS_NUMBER.setBonusNumber(7);

        //등수별로 1개씩 당첨되도록 로또 생성
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        return 2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000;
    }
}