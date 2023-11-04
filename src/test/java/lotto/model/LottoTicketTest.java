package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.service.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    @DisplayName("Lotto리스트를 LottoDto리스트로 잘 반환하는지 확인")
    void convertToDto() {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.addLotto(Arrays.asList(4, 7, 13, 28, 35, 40));
        List<LottoDto> lottoDtos = lottoTicket.toDto();

        assertThat(lottoDtos.size()).isEqualTo(2);
    }

}
