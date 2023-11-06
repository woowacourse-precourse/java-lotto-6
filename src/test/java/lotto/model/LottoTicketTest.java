package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.exception.LottoTicketNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    @DisplayName("LottoTicket 생성 성공")
    void createLottoTicket_success(){
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    }

    @Nested
    @DisplayName("LottoTicket 생성 실패")
    class CreateLottoTicketFail{
        @Test
        @DisplayName("min 값보다 작은 숫자로 생성 시도")
        void outOfRangeLottoNumber_min(){
            Assertions.assertThatThrownBy(() -> new LottoTicket(List.of(0, 1, 2, 3, 4, 5)))
                    .isInstanceOf(LottoTicketNumberException.class);
        }

        @Test
        @DisplayName("max 값보다 큰 숫자로 생성 시도")
        void outOfRangeLottoNumber_max(){
            Assertions.assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 47)))
                    .isInstanceOf(LottoTicketNumberException.class);
        }
        
        @Test
        @DisplayName("중복된 값으로 생성 시도")
        void duplicatedLottoNumber(){
            Assertions.assertThatThrownBy(() -> new LottoTicket(List.of(1,1,2,3,4,5)))
                    .isInstanceOf(LottoTicketNumberException.class);
        }

        @Test
        @DisplayName("로또 번호 개수가 다름")
        void incorrectLottoNumberCount(){
            Assertions.assertThatThrownBy(() -> new LottoTicket(List.of(1,2,3,4,5,6,7)))
                    .isInstanceOf(LottoTicketNumberException.class);
        }
    }

}