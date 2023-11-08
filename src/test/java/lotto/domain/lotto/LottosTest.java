package lotto.domain.lotto;

import lotto.service.dto.LottoResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {
    Lottos lottos;

    @BeforeEach
    void SetUp() {
        lottos = new Lottos();
    }

    @Test
    void 로또_추가() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        int expectedTicketsSize = 1;

        lottos.insertLotto(lotto);

        assertEquals(expectedTicketsSize, lottos.getLottoTickets().size());
    }

    @Test
    void 로또_일괄_매칭() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,6));
        lottos.insertLotto(lotto1);
        lottos.insertLotto(lotto2);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 12;

        List<LottoResultDto> resultDtos = lottos.matchAll(winningNumbers, bonusNumber);

        int expectedDtoSize = 2;
        assertEquals(expectedDtoSize, resultDtos.size());
    }
}
