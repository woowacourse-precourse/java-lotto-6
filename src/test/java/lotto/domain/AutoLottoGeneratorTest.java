package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AutoLottoGeneratorTest {

    @DisplayName("로또 번호가 생성될 때 오름차순으로 정렬되어야 한다.")
    @Test
    public void createLottoOrderByAsc() throws Exception {
        //given
        LottoGenerator testGenerator = new AutoLottoGenerator();

        //when
        List<Integer> testLotto = testGenerator.generateLotto();

        //then
        assertTrue(isSort(testLotto), "로또 번호가 오름차순이 아닙니다.");
    }

    private boolean isSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

}