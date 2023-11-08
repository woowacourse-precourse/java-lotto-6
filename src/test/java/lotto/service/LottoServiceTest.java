package lotto.service;

import lotto.domain.LottoList;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("구매금액에 따른 로또 장수에 맞게 로또 번호를 생성")
    @Test
    void createLottoList() {
        LottoList lottoList = lottoService.createLottoList(14);
        Assertions.assertThat(lottoList.getSize()).isEqualTo(14);
    }

    @DisplayName("모든 로또 번호 출력")
    @Test
    void printAllLotto() {
        LottoList lottoList = lottoService.createLottoList(14);
        lottoService.printAllLottoNumber(lottoList);
    }

    @DisplayName("입력받은 로또 번호와 랜덤 생성한 로또 번호를 비교하여 당첨 확인")
    @Test
    void judgeWinning() {
        LottoList lottoList = lottoService.createLottoList(3);
        WinningLotto winningLotto = new WinningLotto("3,5,9,11,15,31", "8");
        lottoService.printAllLottoNumber(lottoList);
        lottoService.judgeLotto(lottoList, winningLotto);
    }
}
