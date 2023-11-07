package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("유저 구매 로또 생성 테스트 - 정상 데이터 - 성공")
    @Test
    void createUserLottosTest() {
        int testAmount = 3;
        Lottos testLottos =  lottoService.createUserLottos(testAmount);
        assertThat(testLottos.getLottos().size()).isEqualTo(3);
    }

    @DisplayName("당첨 로또 생성 테스트 - 정상 데이터 - 성공")
    @Test
    void createAnswerLottosTest() {
        List<Integer> testLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto testLotto =  lottoService.createAnswerLotto(testLottoNumbers);
        assertThat(testLotto.getNumbers()).isEqualTo(testLottoNumbers);
    }

    @DisplayName("Integer 리스트 오름차순 정렬 테스트 - 성공")
    @Test
    void orderNumbersByAsc() {
        List<Integer> testList = Arrays.asList(3, 2, 1, 4, 6, 5);
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoService.sortNumbersByAsc(testList)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 추첨 결과 테스트 - 0~2개 번호 일치 데이터 - 성공")
    @Test
    void calculateWinningResultFailTest() {
        Lottos testLottos = new Lottos();
        testLottos.addLotto(new Lotto(Arrays.asList(1, 2, 10, 11, 12, 13)));
        testLottos.addLotto(new Lotto(Arrays.asList(1, 10, 11, 12, 13, 14)));
        testLottos.addLotto(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)));
        Lotto answerLotto = new Lotto(Arrays.asList(1, 2, 3, 41, 42, 43));
        BonusNumber bonusNumber = new BonusNumber(45);
        List<Integer> expectedResult = Arrays.asList(1, 1, 1, 0, 0, 0, 0, 0);

        assertThat(lottoService.calculateWinningResult(testLottos, answerLotto, bonusNumber)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 추첨 결과 테스트 - 3~4개 번호 일치 데이터 - 성공")
    @Test
    void calculateWinningResult4th5thTest() {
        Lottos testLottos = new Lottos();
        testLottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)));
        testLottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        Lotto answerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 42, 43));
        BonusNumber bonusNumber = new BonusNumber(45);
        List<Integer> expectedResult = Arrays.asList(0, 0, 0, 1, 1, 0, 0, 0);

        assertThat(lottoService.calculateWinningResult(testLottos, answerLotto, bonusNumber)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 추첨 결과 테스트 - 5개/5개+보너스 번호 일치 데이터 - 성공")
    @Test
    void calculateWinning2nd3rdResultTest() {
        Lottos testLottos = new Lottos();
        testLottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11)));
        testLottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)));
        Lotto answerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 43));
        BonusNumber bonusNumber = new BonusNumber(45);
        List<Integer> expectedResult = Arrays.asList(0, 0, 0, 0, 0, 1, 0, 1);

        assertThat(lottoService.calculateWinningResult(testLottos, answerLotto, bonusNumber)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 추첨 결과 테스트 - 6개 번호 일치 데이터 - 성공")
    @Test
    void calculateWinning1stResultTest() {
        Lottos testLottos = new Lottos();
        testLottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 43)));
        Lotto answerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 43));
        BonusNumber bonusNumber = new BonusNumber(45);
        List<Integer> expectedResult = Arrays.asList(0, 0, 0, 0, 0, 0, 1, 0);

        assertThat(lottoService.calculateWinningResult(testLottos, answerLotto, bonusNumber)).isEqualTo(expectedResult);
    }

    @DisplayName("당첨 로또 순위별 당첨 수량 - 3개/4개 번호 일치 - 성공")
    @Test
    void calculateWinningTimes4th5thTest() {
        List<Integer> testResult = Arrays.asList(0, 0, 0, 1, 1, 0, 0, 0);
        List<String> expectedResult = Arrays.asList("1", "1", "0", "0", "0");

        assertThat(lottoService.calculateEachWinningTimes(testResult)).isEqualTo(expectedResult);
    }

    @DisplayName("당첨 로또 순위별 당첨 수량 - 5개/5개+보너스 번호 일치 - 성공")
    @Test
    void calculateWinningTimes2nd3rdTest() {
        List<Integer> testResult = Arrays.asList(0, 0, 0, 0, 0, 1, 0, 1);
        List<String> expectedResult = Arrays.asList("0", "0", "1", "0", "1");

        assertThat(lottoService.calculateEachWinningTimes(testResult)).isEqualTo(expectedResult);
    }

    @DisplayName("당첨 로또 순위별 당첨 수량 - 6개 번호 일치 - 성공")
    @Test
    void calculateWinningTimes1stTest() {
        List<Integer> testResult = Arrays.asList(0, 0, 0, 0, 0, 0, 1, 0);
        List<String> expectedResult = Arrays.asList("0", "0", "0", "1", "0");

        assertThat(lottoService.calculateEachWinningTimes(testResult)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 당첨 금액 테스트 - 4th + 5th 당첨 케이스 - 성공")
    @Test
    void calculateProfit4th5thTest() {
        List<Integer> testLottoResult = Arrays.asList(0, 0, 0, 1, 1, 0, 0, 0);
        int expectedResult = FOURTH_PRIZE.getWinningAmount() + FIFTH_PRIZE.getWinningAmount();

        assertThat(lottoService.calculateTotalWinningAmount(testLottoResult)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 당첨 금액 테스트 - 3th + 2th 당첨 케이스 - 성공")
    @Test
    void calculateProfit2nd3rdTest() {
        List<Integer> testLottoResult = Arrays.asList(0, 0, 0, 0, 0, 1, 0, 1);
        int expectedResult = SECOND_PRIZE.getWinningAmount() + THIRD_PRIZE.getWinningAmount();

        assertThat(lottoService.calculateTotalWinningAmount(testLottoResult)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 당첨 금액 테스트 - 1st 당첨 케이스 - 성공")
    @Test
    void calculateProfit1stTest() {
        List<Integer> testLottoResult = Arrays.asList(0, 0, 0, 0, 0, 0, 1, 0);
        int expectedResult = FIRST_PRIZE.getWinningAmount();

        assertThat(lottoService.calculateTotalWinningAmount(testLottoResult)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 수익률 테스트 - 1st 당첨 케이스 - 성공")
    @Test
    void calculateProfitRate1stTest() {
        int testLottoAmount = 1000;
        int testTotalWinningAmount = FIRST_PRIZE.getWinningAmount();
        String expectedResult = "200000000.0";

        assertThat(lottoService.calculateTotalProfitRate(testLottoAmount, testTotalWinningAmount)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 수익률 테스트 - 2nd 당첨 케이스 - 성공")
    @Test
    void calculateProfitRate2stTest() {
        int testLottoAmount = 1000;
        int testTotalWinningAmount = SECOND_PRIZE.getWinningAmount();
        String expectedResult = "3000000.0";

        assertThat(lottoService.calculateTotalProfitRate(testLottoAmount, testTotalWinningAmount)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 수익률 테스트 - 3rd 당첨 케이스 - 성공")
    @Test
    void calculateProfitRate3rdTest() {
        int testLottoAmount = 1000;
        int testTotalWinningAmount = THIRD_PRIZE.getWinningAmount();
        String expectedResult = "150000.0";

        assertThat(lottoService.calculateTotalProfitRate(testLottoAmount, testTotalWinningAmount)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 수익률 테스트 - 4th 당첨 케이스 - 성공")
    @Test
    void calculateProfitRate4thTest() {
        int testLottoAmount = 1000;
        int testTotalWinningAmount = FOURTH_PRIZE.getWinningAmount();
        String expectedResult = "5000.0";

        assertThat(lottoService.calculateTotalProfitRate(testLottoAmount, testTotalWinningAmount)).isEqualTo(expectedResult);
    }

    @DisplayName("로또 수익률 테스트 - 5th 당첨 케이스 - 성공")
    @Test
    void calculateProfitRate5thTest() {
        int testLottoAmount = 1000;
        int testTotalWinningAmount = FIFTH_PRIZE.getWinningAmount();
        String expectedResult = "500.0";

        assertThat(lottoService.calculateTotalProfitRate(testLottoAmount, testTotalWinningAmount)).isEqualTo(expectedResult);
    }
}
