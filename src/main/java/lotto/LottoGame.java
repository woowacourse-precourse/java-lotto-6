package lotto;

import util.Converter;
import util.Input;
import util.InputValidator;
import util.Output;

import java.util.List;

public class LottoGame {
    public void run() {
        Money money = inputUserMoney();
    private Money inputUserMoney() {
                String purchaseAmount = Input.purchaseAmount();

                InputValidator.validateDigits(purchaseAmount);
                int money = Integer.parseInt(purchaseAmount);
                InputValidator.validateMinimumMoney(money);

                return new Money(money);
    }

    }
