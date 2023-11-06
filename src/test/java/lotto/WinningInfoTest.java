package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.List;
import lotto.enumerate.Rank;
import lotto.model.WinningInfo;
import lotto.model.WinningNumber;
import lotto.record.LottoNumberRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningInfoTest {

    @Test
    @DisplayName("순위 정보를 구할 수 있다.")
    void getRankMap() {
        List<LottoNumberRecord> list = new ArrayList<>();
        list.add(new LottoNumberRecord(List.of(8, 21, 23, 41, 42, 43)));
        list.add(new LottoNumberRecord(List.of(9, 21, 23, 41, 42, 43)));
        list.add(new LottoNumberRecord(List.of(10, 21, 23, 41, 42, 43)));
        assertSimpleTest(() -> assertThat(
                new WinningInfo(list, new WinningNumber("8, 21, 23, 41, 42, 43", "44"))
                        .getRankMap()
        ).containsOnly(
                entry(Rank.FIRST_PLACE, 1),
                entry(Rank.SECOND_PLACE, 0),
                entry(Rank.THIRD_PLACE, 2),
                entry(Rank.FOURTH_PLACE, 0),
                entry(Rank.FIFTH_PLACE, 0)));
    }
}