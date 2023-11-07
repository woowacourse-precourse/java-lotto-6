package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoGenerator.generateRandomLotto;
import static lotto.domain.LottoGenerator.generateRandomLottos;
import static lotto.util.Constant.LOTTO_NUMBERS_COUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 수량이 제대로 발행되는지 확인하는 기능 테스트")
    void lottoAmountCountTest(){
        //given
        int purchaseAmount = 5;
        List<Lotto> lottos = generateRandomLottos(purchaseAmount);
        //when

        //then
        assertEquals(lottos.size(), purchaseAmount);
    }

    @Test
    @DisplayName("로또 번호는 고정적으로 6개임을 확인하는 기능 테스트")
    void lottoNumberCountTest(){
        //given
        Lotto lotto = generateRandomLotto();
        //when

        //then
        assertEquals(lotto.getLotto().size(), LOTTO_NUMBERS_COUNT);
    }
}
