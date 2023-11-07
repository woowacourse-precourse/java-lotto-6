package lotto;

import lotto.controller.LottoGame;
import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    LottoNumbers lottoNumbers;
    LottoAmount lottoAmount;
    LottoWinningResult lottoWinningResult;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers();
        lottoAmount = new LottoAmount();
        lottoWinningResult = new LottoWinningResult(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7, new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1부터 45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 50, 0, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 잘 생성되는 지 확인한다.")
    @Test
    void generateLottoNumbers() {
        System.out.println(lottoNumbers.generateLottoNumbers());
    }

    @DisplayName("로또 구입 금액에 해당하는 만큼 로또를 발행해야 한다.")
    @Test
    void getPurchaseQuantityOfLotto() {
        assertThat(lottoAmount.getPurchaseQuantityOfLotto(8400)).isEqualTo(8);
    }

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호를 비교한다.")
    @Test
    void getWinningResult() {
        lottoWinningResult.compare(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(2, 3, 4, 11, 33, 41)), new ArrayList<>(Arrays.asList(1, 2, 3, 40, 41, 42)))));
        Map<Rank, Integer> prizeCount = lottoWinningResult.getPrizeCount();
        assertThat(prizeCount.get(Rank.FIFTH)).isEqualTo(2);
    }

    @DisplayName("수익률 계산하기")
    @Test
    void getRateOfReturn() {
        double rateOfReturn = lottoWinningResult.calculateRateOfReturn(8000, 5000);
        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}