package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliverServiceTest {

    @DisplayName("원하는 개수만큼 로또를 발행하는지 확인하기")
    @Test
    void checkLottoNumber(){
        DeliverService service = new DeliverService(10);
        service.generateLotto(10);
        int lottoNum = service.noticeLottoPackageForCheckWinning().size();

        assertEquals(10, lottoNum);
    }

}