package lotto.controller;
import lotto.view.Prompt;
import java.util.ArrayList;
import java.util.List;
import static lotto.util.TypeConvertor.stringToInteger;
import static lotto.util.TypeConvertor.stringToIntegerList;
import static lotto.util.Validator.validateLottoNumbers;

public class LottoController {
    private static final String ERROR_TAG = "[ERROR] ";
    public void play() {

        Integer money = getMoneyFromUser();

        getLottoNumbersFromUser();
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

    public Integer getMoneyFromUser() {
        boolean isDoneToValidateInput = false;
        Integer money = null;
        while (!isDoneToValidateInput) {
            String moneyString = Prompt.forInputMoney();
            try {
                money = stringToInteger(moneyString);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_TAG + e.getMessage());
            }
            isDoneToValidateInput = true;
        }
        return money;
    }
}
