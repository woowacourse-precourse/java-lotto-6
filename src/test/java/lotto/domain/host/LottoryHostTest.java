package lotto.domain.host;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoryHostTest {
    private LottoHost lottoryHost;

    @BeforeEach
    void setUp() {
        lottoryHost = new LottoHost();
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