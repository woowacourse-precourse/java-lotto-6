package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {


    @DisplayName("생성자 메소드 정상 검사")
    @Test
    void ofTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto3 = new Lotto(List.of(21, 22, 23, 24, 25, 26));

        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);
        LottoTicket.of(lottos);
    }

    @DisplayName("Null 또는 0개 예외 검사")
    @Test
    void validateNullAndEmptyTest(){
        assertThatThrownBy(() ->LottoTicket.of(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->LottoTicket.of(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}