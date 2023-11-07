package lotto.dto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class DtoTest {
    @DisplayName("Dto 테스트")
    @Test
    void testSimpleDto() {
        Dto dto = new Dto();
        dto.setMoney(1000);
        dto.setNumbers(List.of(1, 2, 3, 4, 5, 6));
        dto.setBonus(10);
        dto.setLuckyNumbers();

        assertThat(dto.getLuckyNumbers().getBonusNumber()).isEqualTo(10);
        assertThat(dto.getLuckyNumbers().getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(dto.getLottoTickets().getTickets().size()).isEqualTo(1);
    }
}
