package lotto.domainTest;

import lotto.contants.LottoEnum;
import lotto.domain.services.LottoDrawer;
import lotto.util.Printer;
import lotto.controller.view.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDrawerTest {

    @DisplayName("로또 번호가 일치하는 개수에 따라 등수가 매겨진 Map을 반환")
    @Test
    void drawTest(){
        LottoDrawer lottoDrawer = new LottoDrawer(new Output(new Printer()));
        Map<Integer, List<Integer>> lottoList = new HashMap<>();
        lottoList.put(1, List.of(1, 2, 3, 4, 5, 6));
        lottoList.put(2, List.of(1, 2, 3, 4, 5, 9));
        lottoList.put(3, List.of(1, 2, 3, 4, 5, 7));
        lottoList.put(4, List.of(1, 2, 3, 4, 7, 8));
        lottoList.put(5, List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 9;

        Map<LottoEnum.grade, Integer> resultMap = lottoDrawer.draw(lottoList, winningNumbers, bonusNumber);

        assertThat(resultMap.get(LottoEnum.grade.FIRST)).isEqualTo(1);
        assertThat(resultMap.get(LottoEnum.grade.SECOND)).isEqualTo(1);
        assertThat(resultMap.get(LottoEnum.grade.THIRD)).isEqualTo(1);
        assertThat(resultMap.get(LottoEnum.grade.FOURTH)).isEqualTo(1);
        assertThat(resultMap.get(LottoEnum.grade.FIFTH)).isEqualTo(1);
    }
}
