package mytest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Input;
import java.util.List;
import lotto.LottoGroup;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {
    @DisplayName("로또 금액에 따른 개수만큼 로또 생성")
    @Test
    void checkSize() {
        int lottoCount = 4;
        LottoGroup lottoGroup = new LottoGroup(lottoCount);
        List<Lotto> lottoGroups = lottoGroup.getGroupLotto();
        assertEquals(lottoGroups.size(), 4);

    }
}


