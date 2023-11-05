package lotto.domain.result;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoResultTest {

    LottoResult lottoResult = new LottoResult();
    Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    List<Integer> lottoNumbers = testLotto.getNumbers();
    List<Lotto> lottoTicketList = List.of(testLotto);
    List<Integer> userLottoNumbers = List.of(1, 2, 3, 4, 5, 7);
    Integer userBonusNumber = 6;
    List<Integer> prizeCounts = List.of(0, 0, 0, 1, 0);
    List<Integer> initPrizeCounts = List.of(0, 0, 0, 0, 0);

    @DisplayName("당첨된 내용을 출력한다.")
    @Test
    void announceLottoResultTest() {
        List<Integer> testPrizeCounts = lottoResult.announceLottoResult(lottoTicketList, userLottoNumbers, userBonusNumber);

        Assertions.assertEquals(prizeCounts, testPrizeCounts);
    }

    @DisplayName("생성된 로또 목록을 순회하며 로또당 당첨된 Prize를 확인한다.")
    @Test
    void repeatCheckingLottoTest() {
        List<Integer> testCounts = lottoResult.repeatCheckingLotto(lottoTicketList, userLottoNumbers, userBonusNumber);

        Assertions.assertEquals(prizeCounts.size(), testCounts.size());
        Assertions.assertEquals(prizeCounts, testCounts);
    }

    @DisplayName("Prize 항목별로 당첨된 횟수가 담긴 List를 0으로 초기화한다.")
    @Test
    void initiatePrizeCountsTest() {
        List<Integer> testPrizeCounts = lottoResult.initiatePrizeCounts();

        Assertions.assertEquals(initPrizeCounts, testPrizeCounts);
    }

    @DisplayName("생성된 로또와 유저가 입력한 당첨 번호간 겹치는 횟수를 구한다.")
    @Test
    void countMatchedNumbersTest() {
        int testCount = lottoResult.countMatchedNumbers(lottoNumbers, userLottoNumbers);

        Assertions.assertEquals(5, testCount);
    }
}