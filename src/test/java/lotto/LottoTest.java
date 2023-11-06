package lotto;

import lotto.controller.LottoGame;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    LottoNumbers lottoNumbers;
    LottoAmount lottoAmount;
    @BeforeEach
    void setUp(){
         lottoNumbers = new LottoNumbers();
         lottoAmount = new LottoAmount();
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
    void createLottoByOverRange(){
        assertThatThrownBy(()-> new Lotto(List.of(1,2,3,50,0,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 잘 생성되는 지 확인한다.")
    @Test
    void generateLottoNumbers() {
        System.out.println(lottoNumbers.getLottoNumbers());
    }

    @DisplayName("로또 구입 금액에 해당하는 만큼 로또를 발행해야 한다.")
    @Test
    void getPurchaseQuantityOfLotto() {
        assertThat(lottoAmount.getPurchaseQuantityOfLotto(8400)).isEqualTo(8);
    }

    @Test
    void ex() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 1, 3));
        if (list1.equals(list2)) {
            System.out.println("same");
        } else {
            System.out.println("nooooo");
        }
    }

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호 비교 후 각 등수의 개수를 담은 배열을 반환한다.")
    @Test
    void getWinningResult() {
        LottoWinningResult lottoWinningResult = new LottoWinningResult(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 20, 34)));

        int[] result = lottoWinningResult.getWinningResult();
        for (int i = 0; i < 5; i++) {
            System.out.println(result[i]);
        }
    }
}