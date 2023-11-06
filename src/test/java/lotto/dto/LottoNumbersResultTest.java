package lotto.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersResultTest {
    @DisplayName("출력 형식에 맞게 로또 번호를 반환해야 한다.")
    @Test
    void testLottoNumbersFormat() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbersDTO lottoNumbers = new LottoNumbersDTO(lotto.getLotto());
        String formattedNumbers = "[1, 2, 3, 4, 5, 6]";

        //when
        String target = lottoNumbers.getFormattedLottoNumbers();

        //then
        assertThat(target).isEqualTo(formattedNumbers);
    }
}
