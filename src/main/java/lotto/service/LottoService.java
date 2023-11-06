package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.data.UserLotto;
import lotto.validator.MoneyValidator;

public class LottoService {
    private List<UserLotto> userLottos;
    private int spendMoney;
    private int lottoCnt;

    public LottoService() {
        userLottos = new ArrayList<>();
    }

    public void start() {
        getSpendMoney();
    }

    private void getSpendMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String spend = Console.readLine();
        MoneyValidator.validate(spend);
        spendMoney = Integer.parseInt(spend);
        lottoCnt = spendMoney / 1000;
    }
}
