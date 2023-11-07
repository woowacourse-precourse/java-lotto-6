package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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


    @DisplayName("로또 번호 당첨 내역 유효성 검사")
    @Test
    void evaluateWinning_ShouldIdentifyCorrectWinnings() {

        List<Winning> winnings = new ArrayList<>();
        winnings.add(new Winning(3, false, 5000));
        winnings.add(new Winning(4, false, 50000));
        winnings.add(new Winning(5, false, 1500000));
        winnings.add(new Winning(5, true, 30000000));
        winnings.add(new Winning(6, false, 2000000000));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        int winningBonus = 10;

        Lotto ticket = new Lotto(Arrays.asList(1,2,3,4,5,6));
        ticket.evaluateWinning(winningNumbers, winningBonus, winnings);

        assertThat(winnings).anySatisfy(winning -> {
            assertThat(winning.getMatch()).isEqualTo(3);
            assertThat(winning.getBonus()).isFalse();
            assertThat(winning.getTicketCount()).isGreaterThan(0);
        });
    }
}