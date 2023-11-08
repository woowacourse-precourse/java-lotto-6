package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    
    @DisplayName("로또 번호가 1~45 사이의 숫자가 아니라면 예외 발생")
    @Test
    void createLottoOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 금액에 따른 로또 구매 갯수 테스트")
    @Test
    void lottoCountPerMoney() {
    	
    	int userMoney = 7000;
    	int lottoCount = LottoGame.calculateLottoCount(userMoney);
    	
    	assertEquals(7, lottoCount);
    }
    
    @DisplayName("로또 구매 갯수에 따른 생성배열 갯수 테스트")
    @Test
    void lottosSizePerlottoCount() {
    	
    	int lottoCount = 10;

    	List<List<Integer>> lottos = Lotto.create(lottoCount);
    	
    	assertEquals(lottoCount, lottos.size());
    	
    }
    
    @DisplayName("1등일 경우 당첨금 테스트")
    @Test
    void winningRankFirst() {
        WinningRank firstRank = WinningRank.FIRST;

        assertThat(firstRank.getMatchingNumbers()).isEqualTo(6);
        assertThat(firstRank.getWinningmoney()).isEqualTo(2000000000);
    }

    @DisplayName("4등일 경우 당첨금 테스트")
    @Test
    void winningRankFourth() {
        WinningRank firstRank = WinningRank.FOURTH;

        assertThat(firstRank.getMatchingNumbers()).isEqualTo(4);
        assertThat(firstRank.getWinningmoney()).isEqualTo(50000);
    }
    
    @DisplayName("로또 번호 맞춘 갯수를 검증하는 테스트")
    @Test
    void checkMatchingNumbers() {
        List<Integer> userNumbers = List.of(5, 10, 15, 20, 25, 30);
        List<Integer> winningNumbers = List.of(10, 15, 20, 25, 30, 35);

        int matchingNumbers = CheckNum.checkMatchingNumbers(userNumbers, winningNumbers);

        assertThat(matchingNumbers).isEqualTo(5);
    }
    
    
    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitPercentageTest() {
        int winningMoney = 50000; 
        int userMoney = 100000; 
        
        double profit = Profit.calculateProfitPercentage(winningMoney, userMoney);

        assertThat(profit).isEqualTo(50); 
    }

}