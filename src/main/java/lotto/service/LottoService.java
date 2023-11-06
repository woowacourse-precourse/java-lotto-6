package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.data.Lotto;
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
        getUserLottos(lottoCnt);
    }

    private void getSpendMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String spend = Console.readLine();
        MoneyValidator.validate(spend);
        spendMoney = Integer.parseInt(spend);
        lottoCnt = spendMoney / 1000;
    }

    private void getUserLottos(int cnt) {
        System.out.println("\n" + cnt + "개를 구매했습니다.");
        while (cnt-- > 0) {
            userLottos.add(new UserLotto(getRandomLotto()));
        }

        userLottos.forEach(userLotto -> {
            System.out.println(userLotto.toString());
        });
        System.out.println();
    }

    private Lotto getRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
