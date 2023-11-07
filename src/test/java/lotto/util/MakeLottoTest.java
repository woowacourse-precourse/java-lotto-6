package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeLottoTest {
    private MakeLotto makeLotto;

    @BeforeEach
    void setUp(){
        MakeLotto makeLotto = new MakeLotto();
    }


    @Test
    @DisplayName("수 받아서 그 만큼 로또리스트를 만드는지 확인")
    void makeLotto(){
        //given
        int purchaseAmount = 3000;
        //when
        List<Integer> list = makeLotto.makeLottoList(purchaseAmount);
        //then
        assertEquals(list.size(),3);
    }

}