package lotto.model;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottosTest {

    @Test
    void 중복된_랜덤값이_없을때_참반환테스트(){
        Lottos lottos = new Lottos();
        boolean result = lottos.isUnique(3,List.of(1,2,5));
        assertTrue(result);
    }

    @Test
    void 중복된_랜덤값이_있을때_거짓반환테스트(){
        Lottos lottos = new Lottos();
        boolean result = lottos.isUnique(3,List.of(1,2,3));
        assertFalse(result);
    }




}
