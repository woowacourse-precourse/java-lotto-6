package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.constant.LottoConstant;
import lotto.domain.util.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TicketTest {

    @Test
    @DisplayName("랜덤 숫자가 만들어지는 것을 확인한다.")
    void randomNumbers(){
        // given
        Ticket ticket = new Ticket(5000);

        // when
        List<Integer> ticketNumbers = RandomNumber.gernerate();

        // then
        assertThat(ticketNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("랜덤 숫자를 오름차순으로 정리한다.")
    void ascendingNumber(){
        // given
        Ticket ticket = new Ticket(5000);

        // when
        List<Integer> ticketNumbers = RandomNumber.gernerate();
        List<Integer> ascNumbers = ticket.ascendingNumber(ticketNumbers);

        // then
        assertThat(ascNumbers).isSameAs(ascNumbers);
    }

    @ParameterizedTest
    @ValueSource(ints = {14500,13600,15210})
    @DisplayName("로또 구매시 잔금이 남아 구매를 할 수 없다.")
    void createRemain(int wallet){
        assertThatThrownBy(() -> new Ticket(wallet))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "15000,15", "16000,16"}, delimiter = ',')
    @DisplayName("로또 구입을 얼만큼 할 수 있는지 확인한다.")
    void createCount(int wallet, int count){
        // given
        Ticket ticket = new Ticket(wallet);

        // when
        int ticketCount = ticket.ticketCount();

        // then
        assertThat(ticketCount).isEqualTo(count);
    }

}
