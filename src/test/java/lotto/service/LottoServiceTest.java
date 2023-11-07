package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    // 로또 난수 생성해서 LottoList에 잘 들어가는지
    // 당첨 번호랑 로또 비교해서 당첨금 판단하는거 -> 이때 enum 사용
    // 총 수익률 계산
    @DisplayName("구매금액에 따른 로또 장수에 맞게 로또 번호를 생성")
    @Test
    void createLottoList() {
        // 횟수를 받아서, 그만큼 난수를 생성
        lottoService.createLottoList(14); // 이 안에서 1~45 사이의 숫자 6개가 중복없이 생성되고, 그대로 LottoList에 넣어주기만 하면됨
        List<Lotto> allLotto = lottoService.getAllLotto();
        Assertions.assertThat(allLotto.size()).isEqualTo(14);
    }

    @DisplayName("중복이 없이 1~45 사이의 난수를 6개를 생성해서 리스트로 만든다")
    @Test
    void createRandomLotto() {
        List<Integer> randomLotto = lottoService.createRandomLotto();
        Assertions.assertThat(new Lotto(randomLotto)).isNotNull();
    }
}
