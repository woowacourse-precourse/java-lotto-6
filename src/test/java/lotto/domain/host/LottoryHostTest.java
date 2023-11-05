package lotto.domain.host;

import lotto.domain.num.LottoNumResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoryHostTest {
    private LottoryHost lottoryHost;

    @BeforeEach
    void setUp() {
        lottoryHost = new LottoryHost();
    }

    // TODO: 11/5/23 삭제 요망
//    @DisplayName("중복되는 번호가 있는지 확인한다.")
//    @ParameterizedTest
//    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7"})
//    void checkDuplicateWinNum(String targetNum) {
//        // given
//        String numsWin = "1,2,3,4,5,6";
//        String numsBonus = "7";
//
//        // when
//        lottoryHost.pickNum(numsWin, numsBonus);
//        Boolean result = lottoryHost.checkDuplicateWinNum(targetNum);
//
//        // than
//        assertThat(result).isTrue();
//    }
}