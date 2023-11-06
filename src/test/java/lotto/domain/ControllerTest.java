package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ControllerTest {

    @DisplayName("숫자 오름차순 정렬")
    @Test
    void sortNumbers() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(99);
        numberList.add(1);
        numberList.add(13);
        numberList.add(76);
        numberList.add(43);
        numberList.add(4);
        Controller.sortNumbers(numberList);

        Assertions.assertThat(numberList).isEqualTo(List.of(1, 4, 13, 43, 76, 99));
    }

    @Test
    void countMatchingNumbersByLotteryNumber() {
    }

    @Test
    void fillRankList() {
    }

    @Test
    void bonusNumberFlag() {
    }

    @Test
    void changeRankByBonusNumber() {
    }

    @Test
    void fillMatchingNumberCountList() {
    }
}