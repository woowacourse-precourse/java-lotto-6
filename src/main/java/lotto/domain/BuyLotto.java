package lotto.domain;

import lotto.function.InputFunction;
import lotto.function.PrintMessageFunction;
import lotto.function.ValidationFunction;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {

    InputFunction inputFunction = new InputFunction();
    ValidationFunction validationFunction = new ValidationFunction();
    PrintMessageFunction printMessageFunction = new PrintMessageFunction();
    GetLottoNumbers getLottoNumbers = new GetLottoNumbers();

    private List<Lotto> userLottos;

    private int userMoney;

    private int getInputMoney() {
        String inputMoney = inputFunction.getUserInput();
        validationFunction.validateMoneyIsNumber(inputMoney);
        int money = Integer.parseInt(inputMoney);
        return validationFunction.validateMoney(money);
    }

    private int countLottoQuantity(int money) {
        int LottoQuantity = money / 1000;
        printMessageFunction.printBuyResult(LottoQuantity);

        return LottoQuantity;
    }

    public BuyLotto getBuyInfo() {
        int userMoney = getInputMoney();
        List<Lotto> userLottos = new ArrayList<>();
        int LottoQuantity = countLottoQuantity(userMoney);

        for (int i = 0; i < LottoQuantity; i++) {
            Lotto lotto = getLottoNumbers.LottoNumbers();
            userLottos.add(lotto);
        }

        this.userLottos = userLottos;
        this.userMoney = userMoney;

        return this;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public int getUserMoney() {
        return userMoney;
    }


}
