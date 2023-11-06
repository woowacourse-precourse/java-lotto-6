package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.exception.InputMoneyException.*;
import static lotto.util.GenerateRandomList.*;
import static lotto.util.MessageConstant.*;
import static lotto.util.NumberConstant.*;

public class Customer {
    private final Integer MONEY;
    private final List<Lotto> buyLotto;

    public Customer(String money) {
        moneyValidate(money);
        this.MONEY = Integer.parseInt(money);
        this.buyLotto = new ArrayList<>();
    }

    public void buyNewLotto() {
        int goal = calculateLottoNum();
        int count = 0;
        while (count < goal) {
            buyLotto.add(new Lotto(createRandomList()));
            count += 1;
        }
    }

    public int calculateLottoNum() {
        return this.MONEY / MONEY_STANDARD;
    }

    public String calculateRevenueRatio(double winningSum) {
        double result = winningSum / MONEY * MULTIPLY_STANDARD;
        DecimalFormat standard = new DecimalFormat(DECIMAL_FORMAT);
        return standard.format(result);
    }

    public List<String> getLottoTexts() {
        return buyLotto.stream()
                .map(Lotto::getLottoNumbersText)
                .toList();
    }

    public List<Lotto> getAllLotto() {
        return Collections.unmodifiableList(buyLotto);
    }


}
