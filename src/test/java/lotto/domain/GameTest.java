package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @DisplayName("입력한 금액을 통해 로또를 몇장 살 수 있는지 반환한다.")
    @Test
    void countTickets(){
        //given
        Game game = new Game();
        //when
        assertThat(16).isEqualTo(game.countTickets(16000));
        //then
    }

    @DisplayName("입력한 금액이 1000으로 나누어떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void countTicketsException(){
        //given
        Game game = new Game();
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> game.countTickets(13500));

        assertThat(e.getMessage()).isEqualTo("[ERROR]1,000원 단위로만 입력가능합니다.");
    }
    @DisplayName("보너스 번호가 미리 입력 받은 6자리와 다르다면 통과")
    @Test
    void validateDuplicateBonusNumber(){
        //given
        Game game = new Game();
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> game.countTickets(13500));

        assertThat(e.getMessage()).isEqualTo("[ERROR]1,000원 단위로만 입력가능합니다.");
    }

}