package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {
    
    private final int bonusNumber = 10;
    private final int increadCount = 1;
    
    @DisplayName("모든 로또 번호(6개)가 일치하다면 1등 랭킹의 개수가 1 증가한다.")
    @Test
    void increaseFirstRankingCount() {
        // given
        List<Lotto> lottoTickets = createLottoTickets(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = createLotto(1, 2, 3, 4, 5, 6);
        Number number = createNumber(winningNumbers);
        
        // when
        LotteryMachine.drawLotto(lottoTickets, number);
        
        // then
        assertThat(Ranking.FIRST.getCount()).isEqualTo(increadCount);
    }
    
    
    @DisplayName("5개의 로또 번호가 일치하고, 보너스 번호까지 일치하다면 2등 랭킹의 개수가 1 증가한다.")
    @Test
    void increaseSecondRankingCount() {
        // given
        List<Lotto> lottoTickets = createLottoTickets(1, 2, 3, 4, 5, bonusNumber);
        Lotto winningNumbers = createLotto(1, 2, 3, 4, 5, 6);
        Number number = createNumber(winningNumbers);
        
        // when
        LotteryMachine.drawLotto(lottoTickets, number);
        
        // then
        assertThat(Ranking.FIRST.getCount()).isEqualTo(increadCount);
    }
    
    @DisplayName("5개의 로또 번호가 일치하지만, 보너스 번호가 일치하지 않다면 3등 랭킹의 개수가 1 증가한다.")
    @Test
    void increaseThirdRankingCount() {
        // given
        List<Lotto> lottoTickets = createLottoTickets(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = createLotto(1, 2, 3, 4, 5, 7);
        Number number = createNumber(winningNumbers);
        
        // when
        LotteryMachine.drawLotto(lottoTickets, number);
        
        // then
        assertThat(Ranking.FIRST.getCount()).isEqualTo(increadCount);
    }
    
    @DisplayName("4개의 로또 번호가 일치하다면 4등 랭킹의 개수가 1 증가한다.")
    @Test
    void increaseFourthRankingCount() {
        // given
        List<Lotto> lottoTickets = createLottoTickets(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = createLotto(1, 2, 3, 4, 7, 8);
        Number number = createNumber(winningNumbers);
        
        // when
        LotteryMachine.drawLotto(lottoTickets, number);
        
        // then
        assertThat(Ranking.FIRST.getCount()).isEqualTo(increadCount);
    }
    
    @DisplayName("3개의 로또 번호가 일치하다면 5등 랭킹의 개수가 1 증가한다.")
    @Test
    void increaseFifthRankingCount() {
        // given
        List<Lotto> lottoTickets = createLottoTickets(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = createLotto(1, 2, 3, 7, 8, 9);
        Number number = createNumber(winningNumbers);
        
        // when
        LotteryMachine.drawLotto(lottoTickets, number);
        
        // then
        assertThat(Ranking.FIRST.getCount()).isEqualTo(increadCount);
    }
    
    private List<Lotto> createLottoTickets(int number1, int number2, int number3, int number4, int number5, int number6) {
        return List.of(createLotto(number1, number2, number3, number4, number5, number6));
    }
    
    private Lotto createLotto(int number1, int number2, int number3, int number4, int number5, int number6) {
        return new Lotto(List.of(number1, number2, number3, number4, number5, number6));
    }
    
    private Number createNumber(Lotto winningNumbers) {
        return new Number(winningNumbers, bonusNumber);
    }
}
