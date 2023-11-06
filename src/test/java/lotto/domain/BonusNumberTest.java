package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 넘버가 리스트 안에 포함되면 true 포함되지 않으면 false를 반환한다.")
    void containBonusNumberTest() {
        //given
        BonusNumber bonusNumber = new BonusNumber(6);
        List<Integer> lottoNumbersTrue = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbersFalse = List.of(11, 12, 13, 14, 15, 16);

        //when
        boolean expectTrue = bonusNumber.containBonusNumber(lottoNumbersTrue);
        boolean expectFalse = bonusNumber.containBonusNumber(lottoNumbersFalse);

        //then
        assertThat(expectTrue).isEqualTo(true);
        assertThat(expectFalse).isEqualTo(false);
    }
}