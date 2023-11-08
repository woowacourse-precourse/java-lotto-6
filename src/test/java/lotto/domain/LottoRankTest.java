package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoRankTest {

    @Test
    @DisplayName("로또번호와 당첨번호를 입력받아서 1등을 반환")
    void getFirstPlaceRank() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(8, 21, 23, 41, 42, 43), 1);

        LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);

        Assertions.assertThat(lottoRank).isInstanceOf(lottoRank.getClass()).isEqualTo(LottoRank.FIRST_PLACE);
    }

}