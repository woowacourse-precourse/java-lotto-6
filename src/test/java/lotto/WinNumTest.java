package lotto;

import lotto.domain.WinNum;
import lotto.enums.LottoEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WinNumTest {

    @Test
    void count() {
        // given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);// 당첨번호
        int bonusNum = 7; // 보너스 번호
        WinNum winNum = new WinNum(list, bonusNum);

        // when
        int count = winNum.count(2);
        int count2 = winNum.count(7);

        int bonusCount = winNum.bonusCount(7);
        int bonusCount2 = winNum.bonusCount(0);

        // then
        Assertions.assertThat(count).isEqualTo(1);
        Assertions.assertThat(count2).isEqualTo(0);
        Assertions.assertThat(bonusCount).isEqualTo(1);
        Assertions.assertThat(bonusCount2).isEqualTo(0);

    }

    @Test
    void print() {
        LottoEnum[] values = LottoEnum.values();
        Arrays.sort(values, Comparator.reverseOrder());
        for (LottoEnum value : values) {
            System.out.println(value);
        }
    }

}
