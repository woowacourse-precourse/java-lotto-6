package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("로또 발행기로 발행한 로또 번호에는 중복이 없다.")
    @Test
    void checkDuplication(){
        boolean isDup = false;
        LottoGenerator generator = new LottoGenerator();
        List<Integer> list = generator.generate();
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j< list.size(); j++){
                isDup = list.get(i).equals(list.get(j));
            }
        }

        assertFalse(isDup);
    }

    @DisplayName("로또 발행기로 발행된 로또 번호의 개수는 항상 6개")
    @Test
    void checkLottoSize(){
        LottoGenerator generator = new LottoGenerator();
        assertEquals(6, generator.generate().size());
    }
}