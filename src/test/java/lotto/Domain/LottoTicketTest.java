package lotto.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    @DisplayName("Lottos 객체생성 개수 테스트")
    public void createLottosTest() {
        int lottoCount = 5;
        LottoTicket lottoTicket = new LottoTicket(lottoCount);

        assertThat(lottoTicket.getSize()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("로또 티켓의 문자열 반환 테스트")
    void getLottosStringTest() {
        LottoTicket lottoTicket = new LottoTicket(3);
        List<String> lottosNumbers = lottoTicket.getLottoString();

        assertEquals(3, lottosNumbers.size());

        for (String lottoNumbers : lottosNumbers) {
            assertTrue(lottoNumbers.matches("\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+\\]"));
        }
    }
}
