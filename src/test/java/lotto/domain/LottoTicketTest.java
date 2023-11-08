package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("LottoTicket이 생성될 때 내부 Lotto 객체의 번호를 정확히 반환한다")
    void getNumbers_ShouldReturnLottoNumbers() {
        // 준비
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(expectedNumbers);
        LottoTicket lottoTicket = new LottoTicket(lotto);

        // 실행
        List<Integer> actualNumbers = lottoTicket.getNumbers();

        // 검증
        assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    @DisplayName("LottoTicket의 가격이 올바르게 반환된다")
    void price_ShouldReturnCorrectPrice() {
        // 실행 & 검증
        assertThat(LottoTicket.PRICE).isEqualTo(1000);
    }
}
