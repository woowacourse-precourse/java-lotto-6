package lotto.controller;
import lotto.entity.Lotto;
import lotto.service.LottoService;
import lotto.view.Prompt;
import java.util.ArrayList;
import java.util.List;
import static lotto.util.TypeConvertor.stringToInteger;
import static lotto.util.TypeConvertor.stringToIntegerList;
import static lotto.util.Validator.validateLottoNumbers;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private static final String ERROR_TAG = "[ERROR] ";
    public void play() {

        Integer money = getMoneyFromUser();
        List<Lotto> boughtLotto = lottoService.buyLotto(money);

        Prompt.forShowLottoList(boughtLotto);

        List<Integer> lottoNumbers = getLottoNumbersFromUser();

    }

    public Integer getMoneyFromUser() {
        boolean isDoneToValidateInput = false;
//        Integer money = null;
        while (!isDoneToValidateInput) {
            String moneyString = Prompt.forInputMoney();
            try {
                Integer money = stringToInteger(moneyString);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + e.getMessage());
            }
            isDoneToValidateInput = true;
        }
        return 0;
//        return money;
    }

    private List<Integer> getLottoNumbersFromUser() {
        boolean isDoneToValidateInput = false;
        List<Integer> lottoNumberList = null;

        while (!isDoneToValidateInput) {
            String NumberString = Prompt.forInputLottoNumbers();
            try {
                lottoNumberList = stringToIntegerList(NumberString);

            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + e.getMessage());
            }
            isDoneToValidateInput = true;
        }
        return lottoNumberList;
    }


}
