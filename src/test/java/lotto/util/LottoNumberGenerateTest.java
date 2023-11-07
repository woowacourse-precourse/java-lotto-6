package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGenerateTest {
    @DisplayName("로또를 지정한 갯수(5개)만큼 로또를 만들어 내는지 테스트")
    @Test
    void generateRightNumberOfLottosTest(){
        List<Lotto> lottos =  LottoNumberGenerate.generateLottos(5);
        Assertions.assertEquals(lottos.size(), 5);
    }

    @DisplayName("생성한 로또가 올바르게 생성 되었는지 테스트")
    @Test
    void generateRightLottoTest(){
        List<Lotto> lottos =  LottoNumberGenerate.generateLottos(5);
        for(Lotto lotto:lottos){
            Assertions.assertEquals(lotto.getNumbers().size(), 6);
        }
    }
}
