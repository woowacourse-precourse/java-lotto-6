package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.PurchasedLottoNumbers;
import lotto.domain.User;
import lotto.domain.dto.PurchasedLottoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("구입 금액만큼 로또가 생성되는지 검사한다.")
    public void 로또_구매() throws Exception {
        //given
        User user = new User("10000");

        //when
        List<Lotto> purchasedLotto = LottoService.lottoGenerator(user.getAmount());

        //then
        //purchasedLotto.getPurchasedLotto().size();
        assertEquals(10, purchasedLotto.size());
    }

    @Test
    @DisplayName("생성된 로또가 출력되는지 검사한다.")
    public void 로또_출력() throws Exception {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        Lotto lotto3 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);

        //when
        PurchasedLottoNumbers purchasedLottoNumbers = new PurchasedLottoNumbers(lottos);
        PurchasedLottoDTO purchasedLottoDTO = LottoService.purchasedLottoToDTO(purchasedLottoNumbers);

        //then
        String lottoDTO1 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(0).getNumbers().toArray());
        String lottoDTO2 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(1).getNumbers().toArray());
        String lottoDTO3 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(2).getNumbers().toArray());
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6]", lottoDTO1);
        Assertions.assertEquals("[10, 11, 12, 13, 14, 15]", lottoDTO2);
        Assertions.assertEquals("[40, 41, 42, 43, 44, 45]", lottoDTO3);
    }
}
