package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void 로또_번호_초기화_테스트() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0)));
        lotto.setNumber(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 2, 1)));
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(3, 4, 5, 6, 2, 1));
    }

    @Test
    void 랜덤_중복_테스트() { // pickUniqueNumbersInRange 메소드 자체가 중복 없음
        assertThat(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().distinct().count()).isEqualTo(6);
    }
}