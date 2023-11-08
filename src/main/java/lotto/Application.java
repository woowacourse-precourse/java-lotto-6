package lotto;

import lotto.service.LottoService;
import lotto.service.ValidationService;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        ValidationService validationService = new ValidationService();
        LottoService lottoService = new LottoService();

        int buyLotto = validationService.validationBuyMoney();
        lottoService.buyLotto(buyLotto);

        List<Integer> successLottoNumbers = validationService.validationSuccessLotto();
        lottoService.setSuccessLotto(successLottoNumbers);

        int bonusLottoNumber = validationService.validationBonusLotto(successLottoNumbers);
        lottoService.setBonusLottoNumber(bonusLottoNumber);

        lottoService.calcLotto();


    }

}
