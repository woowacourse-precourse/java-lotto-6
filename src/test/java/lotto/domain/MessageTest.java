package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Message.*;

class MessageTest {

    @Test
    void 공백문구_테스트() {
        String expected = BLANK.getMessage();

        Assertions.assertThat(BLANK.getMessage())
                .isEqualTo(expected);
    }

    @Test
    void 구입금액_입력문구_테스트() {
        String expected = PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage();

        Assertions.assertThat(PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage())
                .isEqualTo(expected);
    }
    
    @Test
    void 구매개수_문구_테스트() {
        int purchaseCount = 10;
        String expected = PURCHASE_AMOUNT_BUY_MESSAGE.getMessage()
                .replace("n", String.valueOf(purchaseCount));

        Assertions.assertThat(PURCHASE_AMOUNT_BUY_MESSAGE.getBuyMessage(purchaseCount))
                .isEqualTo(expected);
    }

    @Test
    void 구매개수_문구_예외테스트1() {
        int purchaseCount = 10;
        String expected = BLANK.getMessage();

        Assertions.assertThat(BLANK.getBuyMessage(purchaseCount))
                .isEqualTo(expected);
    }

    @Test
    void 구매개수_문구_예외테스트2() {
        int purchaseCount = 10;
        String expected = PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage();

        Assertions.assertThat(PURCHASE_AMOUNT_INPUT_MESSAGE.getBuyMessage(purchaseCount))
                .isEqualTo(expected);
    }

    @Test
    void 로또_번호문구_테스트() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> numbers = lottoNumbers.stream().map(String::valueOf).toList();
        String expected = PUBLISHED_LOTTO_NUMBER_MESSAGE.getMessage()
                        .replace("ZERO", numbers.get(0))
                        .replace("ONE", numbers.get(1))
                        .replace("TWO", numbers.get(2))
                        .replace("THREE", numbers.get(3))
                        .replace("FOUR", numbers.get(4))
                        .replace("FIVE", numbers.get(5));

        Assertions.assertThat(PUBLISHED_LOTTO_NUMBER_MESSAGE.getPublishedLottoMessage(lottoNumbers))
                .isEqualTo(expected);
    }

    @Test
    void 로또_번호문구_예외테스트1() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String expected = BLANK.getMessage();

        Assertions.assertThat(BLANK.getPublishedLottoMessage(lottoNumbers))
                .isEqualTo(expected);
    }

    @Test
    void 로또_번호문구_예외테스트2() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String expected = PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage();

        Assertions.assertThat(PURCHASE_AMOUNT_INPUT_MESSAGE.getPublishedLottoMessage(lottoNumbers))
                .isEqualTo(expected);
    }

    @Test
    void 당첨번호_입력문구_테스트() {
        String expected = WINNING_NUMBER_INPUT_MESSAGE.getMessage();

        Assertions.assertThat(WINNING_NUMBER_INPUT_MESSAGE.getMessage())
                .isEqualTo(expected);
    }

    @Test
    void 보너스번호_입력문구_테스트() {
        String expected = BONUS_NUMBER_INPUT_MESSAGE.getMessage();

        Assertions.assertThat(BONUS_NUMBER_INPUT_MESSAGE.getMessage())
                .isEqualTo(expected);
    }


    @Test
    void 당첨통계_문구_테스트() {
        int purchaseAmount = 5000;
        WinningResult winningResult = new WinningResult();
        winningResult.addThreeMatches();
        winningResult.addFourMatches();
        winningResult.addFiveMatches();
        winningResult.addFiveAndBonusMatches();
        winningResult.addSixMatches();
        winningResult.calculateTotalReturn(purchaseAmount);

        String expected = BONUS_NUMBER_INPUT_MESSAGE.getMessage()
                .replace("THREE", String.valueOf(winningResult.getThreeMatches()))
                .replace("FOUR", String.valueOf(winningResult.getFourMatches()))
                .replace("FIVE", String.valueOf(winningResult.getFiveMatches()))
                .replace("BONUS", String.valueOf(winningResult.getFiveAndBonusMatches()))
                .replace("SIX", String.valueOf(winningResult.getSixMatches()))
                .replace("TOTAL_RETURN", String.valueOf(winningResult.getTotalReturn()));

        Assertions.assertThat(BONUS_NUMBER_INPUT_MESSAGE.getWinningResultMessage(winningResult))
                .isEqualTo(expected);
    }

    @Test
    void 당첨통계_문구_예외테스트1() {
        int purchaseAmount = 5000;
        WinningResult winningResult = new WinningResult();
        winningResult.addThreeMatches();
        winningResult.addFourMatches();
        winningResult.addFiveMatches();
        winningResult.addFiveAndBonusMatches();
        winningResult.addSixMatches();
        winningResult.calculateTotalReturn(purchaseAmount);

        String expected = BLANK.getMessage();

        Assertions.assertThat(BLANK.getWinningResultMessage(winningResult))
                .isEqualTo(expected);
    }

    @Test
    void 당첨통계_문구_예외테스트2() {
        int purchaseAmount = 5000;
        WinningResult winningResult = new WinningResult();
        winningResult.addThreeMatches();
        winningResult.addFourMatches();
        winningResult.addFiveMatches();
        winningResult.addFiveAndBonusMatches();
        winningResult.addSixMatches();
        winningResult.calculateTotalReturn(purchaseAmount);

        String expected = BONUS_NUMBER_INPUT_MESSAGE.getMessage();

        Assertions.assertThat(BONUS_NUMBER_INPUT_MESSAGE.getWinningResultMessage(winningResult))
                .isEqualTo(expected);
    }
}