package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoManagerTest {
    LottoManager lottoManager;
    @BeforeEach
    void setUp(){
        lottoManager = new LottoManager();
    }
    @Test
    void addLottoTest1(){
        int beforeLength=lottoManager.getLottoList().size();
        lottoManager.addLotto(new Lotto(List.of(1,3,5,7,9,11)));
        List<Lotto> lottoList = lottoManager.getLottoList();
        int AfterLength = lottoList.size();
        assertEquals(AfterLength-beforeLength,1);
    }

    @Test
    void addLottoTest2(){
        lottoManager.addLotto(new Lotto(List.of(1,3,5,7,9,11)));
        List<Lotto> lottoList = lottoManager.getLottoList();
        Lotto recentLotto = lottoList.get(lottoList.size()-1);
        assertEquals(recentLotto.getNumbers(),List.of(1,3,5,7,9,11));
    }
}
