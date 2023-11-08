package lotto.service;

import static lotto.service.LottoService.lottoGenerator;
import static lotto.service.LottoService.purchasedLottoToDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.domain.User;
import lotto.dto.PurchasedLottoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("구입 금액만큼 로또가 생성되는지 검사한다.")
    public void 로또_구매() throws Exception {
        //given
        User user = new User(10000);

        //when
        PurchasedLotto purchasedLottoNumbers = lottoGenerator(user.getAmount());
        List<Lotto> purchasedLotto = purchasedLottoNumbers.getPurchasedLotto();

        //then
        //purchasedLotto.getPurchasedLotto().size();
        assertEquals(10, purchasedLotto.size());
    }

    @Test
    @DisplayName("생성된 로또가 출력되는지 검사한다.")
    public void 로또_출력() throws Exception {
        //given
        PurchasedLotto purchasedLotto = lottoGenerator(3000);

        //when
        PurchasedLottoDTO purchasedLottoDTO = purchasedLottoToDTO(purchasedLotto);

        String lottoDTO1 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(0).getNumbers().toArray());
        String lottoDTO2 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(1).getNumbers().toArray());
        String lottoDTO3 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(2).getNumbers().toArray());

        //then
        Assertions.assertEquals(
                Arrays.toString(purchasedLotto.getPurchasedLotto().get(0).getNumbers().toArray()), lottoDTO1);
        Assertions.assertEquals(
                Arrays.toString(purchasedLotto.getPurchasedLotto().get(1).getNumbers().toArray()), lottoDTO2);
        Assertions.assertEquals(
                Arrays.toString(purchasedLotto.getPurchasedLotto().get(2).getNumbers().toArray()), lottoDTO3);
    }
}
