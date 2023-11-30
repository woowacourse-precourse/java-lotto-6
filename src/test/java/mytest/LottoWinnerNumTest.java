package mytest;

import lotto.LottoWinnerNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerNumTest {
    @DisplayName("7개의 숫자 입력시 예외출력")
    @Test
    void checkOverSizeNum() {
        List<Integer> list = new ArrayList<>();
        int[] group = {1, 2, 3, 4, 5, 6, 7};
        for (int number : group) {
            list.add(number);
        }
        int bonusNum = 11;
        assertThatThrownBy(() -> new LottoWinnerNum(list, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}