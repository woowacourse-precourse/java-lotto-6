package lotto.model.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayDTOTest {
    PayDTO payDTO;

    @BeforeEach
    void beforeEach() {
        payDTO = PayDTO.from("2000");
    }

    @DisplayName("2000원으로 살 수 있는 로또의 수")
    @Test
    void getNumberOfLottoTest() {
        Assertions.assertThat(payDTO.getNumberOfLotto()).isEqualTo(2);
    }

}