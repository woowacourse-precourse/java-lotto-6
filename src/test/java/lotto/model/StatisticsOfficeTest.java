package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsOfficeTest {

    @DisplayName("당첨 번호 추첨 시 로또 번호 6개와 로또 번호에 해당하는 보너스 번호 1개를 뽑는다.")
    @Test
    void registerWinningLotto(){
        List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        Integer bonusNumber = Integer.valueOf(7);
        assertThat(StatisticsOffice.registerWinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(StatisticsOffice.class);
    }

}