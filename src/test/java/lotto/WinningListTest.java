package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.WinningInfo;
import lotto.model.WinningList;
import lotto.model.WinningNumber;
import lotto.record.AmountRecord;
import lotto.record.LottoNumberRecord;
import org.junit.jupiter.api.Test;

class WinningListTest {

    @Test
    void printWinningListString() {
        List<LottoNumberRecord> list = new ArrayList<>();
        list.add(new LottoNumberRecord(List.of(8, 21, 23, 41, 42, 43)));
        list.add(new LottoNumberRecord(List.of(9, 21, 23, 41, 42, 43)));
        list.add(new LottoNumberRecord(List.of(10, 21, 23, 41, 42, 43)));
        WinningInfo winningInfo = new WinningInfo(list,
                new WinningNumber("8, 21, 23, 41, 42, 43", "44"));
        assertSimpleTest(() -> assertThat(
                new WinningList(winningInfo).printWinningListString()
        ).contains("3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 2개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개"));
    }

    @Test
    void calculateProfitRate() {
        List<LottoNumberRecord> list = new ArrayList<>();
        list.add(new LottoNumberRecord(List.of(8, 21, 23, 41, 42, 43)));
        list.add(new LottoNumberRecord(List.of(9, 21, 23, 41, 42, 43)));
        list.add(new LottoNumberRecord(List.of(10, 21, 23, 41, 42, 43)));
        WinningInfo winningInfo = new WinningInfo(list,
                new WinningNumber("8, 21, 23, 41, 42, 43", "44"));
        assertSimpleTest(() -> assertThat(
                new WinningList(winningInfo).calculateProfitRate(new AmountRecord(3000)).printProfitRate()
        ).contains("66766666.7%"));
    }
}