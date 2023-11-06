package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.dto.LottoTicket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @DisplayName("발행 로또 정보 DTO 테스트")
    @Test
    void tickets() {
        lottoService.init(5);

        List<LottoTicket> dtos = lottoService.tickets();

        assertThat(dtos.size()).isEqualTo(5);
        assertThat(dtos).allSatisfy(dto -> assertThat(dto.numbers()).isSorted());
    }
}