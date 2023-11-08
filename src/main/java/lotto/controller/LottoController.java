package lotto.controller;
import lotto.entity.Lotto;
import lotto.entity.LottoResult;
import lotto.entity.User;
import lotto.service.LottoService;
import lotto.view.Prompt;
import java.util.ArrayList;
import java.util.List;
import static lotto.util.TypeConvertor.stringToInteger;
import static lotto.util.TypeConvertor.stringToIntegerList;
import static lotto.util.Validator.checkDuplcate;
import static lotto.util.Validator.validateLottoNumbers;
import static lotto.view.Prompt.showResult;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private static final String ERROR_TAG = "[ERROR] ";
    public void play() {
        Integer money = getMoneyFromUser();
        List<Lotto> boughtLotto = lottoService.buyLotto(money);

        Prompt.forShowLottoList(boughtLotto);

        List<Integer> lottoNumbers = getLottoNumbersFromUser();
        Integer bonusNumber = getBonusNumbersFromUser(lottoNumbers);
        User user = new User(money, lottoNumbers, bonusNumber);

        LottoResult lottoResult = lottoService.matchResult(user, boughtLotto);
        showResult(lottoResult, user);
    }

    public Integer getMoneyFromUser() {
        boolean isDoneToValidateInput = false;
        Integer money = null;
        while (!isDoneToValidateInput) {
            String moneyString = Prompt.forInputMoney();
            try {
                money = stringToInteger(moneyString);
                isDoneToValidateInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + e.getMessage());
            }
        }
        return money;
    }

    private List<Integer> getLottoNumbersFromUser() {
        boolean isDoneToValidateInput = false;
        List<Integer> lottoNumberList = null;
        while (!isDoneToValidateInput) {
            String NumberString = Prompt.forInputLottoNumbers();
            try {
                lottoNumberList = stringToIntegerList(NumberString);
                isDoneToValidateInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + e.getMessage());
            }
        }
        return lottoNumberList;
    }

    private Integer getBonusNumbersFromUser(List<Integer> lottoNumbers) {
        boolean isDoneToValidateInput = false;
        Integer bonusNumber = null;
        while (!isDoneToValidateInput) {
            try {
            bonusNumber = Prompt.forInputBonusNumber();
                checkDuplcate(lottoNumbers, bonusNumber);
                isDoneToValidateInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + e.getMessage());
            }
        }
        return bonusNumber;
    }
}
