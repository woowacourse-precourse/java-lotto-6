package lotto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.InputData;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
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
    
    @Test
    @DisplayName("로또 객체의 numbers 인스턴스 변수에 Randoms 배열을 할당할 때 중복이 있는지 확인")
    void checkLottoNumbersUniqueSix() {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      Lotto lotto = new Lotto(numbers);
      int uniqueCount = (int) numbers.stream().distinct().count();
      assertEquals(uniqueCount, lotto.getNumbers().size());
    }

    @Test
    @DisplayName("1000단위당 한 개씩 있는 로또 객체 리스트 생성 메소드 테스트")
    void shouldCreateOneLottoPerThousandUnits() {
      int testThousand = 6100;
      List<Lotto> lottos = LottoService.createObjectPerThousandUnits(testThousand);
      assertEquals(6, lottos.size(), "6100을 넣고, 1000단위이기 때문에 list의 사이즈는 6이어야 합니다.");
    }

    @Test
    @DisplayName("로또 숫자들(원소들) 텍스트 출력을 확인")
    void testPlayerLottoNumbersDisplayCorrectly() {
      List<Lotto> lottos = LottoService.createObjectPerThousandUnits(5000);
      OutputView.printPlayerLottos(lottos);
    }

    @Test
    @DisplayName("등수에 따른 상금이 정상적으로 추출되는지 확인")
    void testGetTotalWinningAmountSuccess() {
      final int TOP_THREE_PRIZES_TOTAL = 2_031_500_000; // 1, 2, 3등 합친 금액
      int bonusNumber = 7;
      List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
      List<Integer> numbersFirst = List.of(1, 2, 3, 4, 5, 6);
      Lotto firstLotto = new Lotto(numbersFirst);
      List<Integer> numbersSecond = List.of(1, 2, 3, 4, 5, 7);
      Lotto secondLotto = new Lotto(numbersSecond);
      List<Integer> numbersThird = List.of(1, 2, 3, 4, 5, 10);
      Lotto thirdLotto = new Lotto(numbersThird);
      List<Lotto> playerLottos = List.of(firstLotto, secondLotto, thirdLotto);
      assertEquals(TOP_THREE_PRIZES_TOTAL, 
                   LottoService.getTotalWinningAmount(playerLottos, winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("각 등수가 정확히 카운트되는지 확인")
    void testGetTotalWinningCountSuccess() {
      int bonusNumber = 7;
      List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
      List<Integer> numbersFirst = List.of(1, 2, 3, 4, 5, 6);
      Lotto firstLotto = new Lotto(numbersFirst);
      List<Integer> numbersSecond = List.of(1, 2, 3, 4, 5, 7);
      Lotto secondLotto = new Lotto(numbersSecond);
      List<Integer> numbersThird = List.of(1, 2, 3, 4, 5, 10);
      Lotto thirdLotto = new Lotto(numbersThird);
      List<Integer> numbersThird2 = List.of(1, 2, 3, 4, 5, 10);
      Lotto thirdLotto2 = new Lotto(numbersThird2);
      List<Lotto> playerLottos = List.of(firstLotto, secondLotto, thirdLotto, thirdLotto2); // 1등 1개, 2등 1개, 3등 2개
      
      Map<String, Integer> winningCount = LottoService.getTotalWinningRankCount(playerLottos, winningNumbers, bonusNumber);
      assertEquals(1, winningCount.get("FIRST"));
      assertEquals(1, winningCount.get("SECOND"));
      assertEquals(2, winningCount.get("THIRD"));
    }

    @Test
    @DisplayName("수익률 계산이 정확한지 확인")
    void shouldCalculateCorrectReturnOnInvestment() {
      final double EXPECTED_RETURN = 62.5;
      List<Lotto> playerLottos = LottoService.createObjectPerThousandUnits(8000);
      assertEquals(EXPECTED_RETURN, 
                   LottoService.calculateReturnOnInvestment(5000, playerLottos));
    }

}