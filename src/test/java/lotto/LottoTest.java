package lotto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
    
    @DisplayName("로또 객체의 numbers 인스터스 변수에 Randoms배열을 할당할 떄, 중복이 있는지.")
    @Test
    void checkLottoNumbersUniqueSix() {
    	List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    	Lotto lotto = new Lotto(numbers);
    	int uniqueCount = (int) numbers.stream().distinct().count();
    	assertEquals(uniqueCount,lotto.getNumbers().size());
    	
    }
    
    @DisplayName("1000단위당 한개씩 있는 로또 객체 리스트 생성 메소드 테스트")
    @Test
    void shouldCreateOneLottoPerThousandUnits() {
    	int testThousand = 6100;
    	List<Lotto> lotto_list = LottoService.createObjectPerThousandUnits(testThousand);
    	assertEquals(6, lotto_list.size(),"6100을 넣고, 1000단위이기 떄문에 list의 사이즈는 6이어야 합니다.");
    }

    @DisplayName("로또 숫자들(원소들) 텍스트 출력 확인한다.")
    @Test
    void testPlayerLottoNumbersDisplayCorrectly() {
    	List<Lotto> lotto_list = LottoService.createObjectPerThousandUnits(5000);
    	OutputView.printPlayerLottos(lotto_list);
    }
    
    @DisplayName("등수에 따른 상금이 정상적으로 추출 되는지 확인한다")
    @Test
    void testGetTotalWinningAmountSuccess() {
    	int topThreePrizesTotal = 2031500000; //1,2,3등 합친금액
    	int bonusNumber = 7;
    	List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
    	List<Integer> numbersFirst = List.of(1,2,3,4,5,6);
    	Lotto firstLotto = new Lotto(numbersFirst);
    	List<Integer> numbersSecond = List.of(1,2,3,4,5,7);
    	Lotto secondLotto = new Lotto(numbersSecond);
    	List<Integer> numbersthird = List.of(1,2,3,4,5,10);
    	Lotto thirdLotto = new Lotto(numbersthird);
    	List<Lotto> playerLottos = List.of(firstLotto,secondLotto,thirdLotto);
    	assertEquals(topThreePrizesTotal, LottoService.getTotalWinningAmount(playerLottos, winningNumbers, bonusNumber));
    }
    
//    @DisplayName("각 등수가 정확히 카운트 되는지 확인한다.")
//    @Test
//    void testGetTotalWinningCountSuccess() {
//    	int topThreePrizesTotal = 2031500000; //1,2,3등 합친금액
//    	int bonusNumber = 7;
//    	List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
//    	List<Integer> numbersFirst = List.of(1,2,3,4,5,6);
//    	Lotto firstLotto = new Lotto(numbersFirst);
//    	List<Integer> numbersSecond = List.of(1,2,3,4,5,7);
//    	Lotto secondLotto = new Lotto(numbersSecond);
//    	List<Integer> numbersthird = List.of(1,2,3,4,5,10);
//    	Lotto thirdLotto = new Lotto(numbersthird);
//    	List<Lotto> playerLottos = List.of(firstLotto,secondLotto,thirdLotto);
//    	assertEquals(topThreePrizesTotal, LottoService.getTotalWinningAmount(playerLottos, winningNumbers, bonusNumber));
//    }
    
}