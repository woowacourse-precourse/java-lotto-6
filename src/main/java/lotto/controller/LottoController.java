package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.Ranks;
import lotto.service.LottoService;

public class LottoController {

    public List<Lotto> buyLottery(Price purchasePrice) {
        LottoService lottoService = new LottoService();
        return lottoService.buyLottery(purchasePrice);
    }

    private void validatePurchasePriceRange(Integer purchasePrice) {
        if (purchasePrice % 1_000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    private void validatePurchasePriceType(String purchasePrice) {
        try {
            Integer.valueOf(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 금액은 숫자만 입력 가능합니다.");
        }
    }

    public Ranks lottoResults(List<Lotto> lottery, List<LottoNumber> winningNumber, LottoNumber bonusNumber) {

        LottoService lottoService = new LottoService();
        return lottoService.lottoResults(lottery, winningNumber, bonusNumber);
    }


}
