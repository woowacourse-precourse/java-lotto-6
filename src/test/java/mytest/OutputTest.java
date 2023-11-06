package mytest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import lotto.Lotto;
import lotto.LottoGroup;
import lotto.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
class OutputTest {
    @DisplayName("로또 개수에 맞춰 발행한 로또 출력")
    @Test
    void showLottoGroup(){
        int lottoCount = 3;
        LottoGroup lottoGroup = new LottoGroup(lottoCount);
        List<Lotto> lottoGroups = lottoGroup.getGroupLotto();
        Output.showLottoGroupNum(lottoGroup);
    }

}