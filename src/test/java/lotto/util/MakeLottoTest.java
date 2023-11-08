package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MakeLottoTest {
    private MakeLotto makeLotto;

    @BeforeEach
    void setUp() {
        MakeLotto makeLotto = new MakeLotto();
    }


    @Test
    @DisplayName("수 받아서 그 만큼 로또리스트를 만드는지 확인")
    void makeLottoList() {
        //given
        int lottoCount = 6;
        //when
        List<Lotto> list = new MakeLotto().makeLottoList(lottoCount);
        //then
        assertEquals(list.size(), 6);
    }


}