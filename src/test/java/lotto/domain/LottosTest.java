package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private Lottos lottos;
    private Lotto lotto1;
    private Lotto lotto2;

    @BeforeEach
    void setUp(){
        lottos = new Lottos();
        lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        lotto2 = new Lotto(List.of(7,8,9,10,11,12));
    }

    @Test
    void 로또_추가_테스트(){
        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);

        assertEquals(2,lottos.getLottos().size());
        assertTrue(lottos.getLottos().contains(lotto1));
        assertTrue(lottos.getLottos().contains(lotto2));
    }

}
