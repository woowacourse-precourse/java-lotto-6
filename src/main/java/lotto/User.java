package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    int money;
    List<Lotto> lottos;

    public User() {
        Output.printGameStartMessage();
        money = inputMoney();
        Output.printUserMoney(money);
    }

    public void buyLotto(int lottoPirce) {
        int numberOfLotto = money / lottoPirce;
        Output.printNumberOfLottos(numberOfLotto);

        lottos = LottoGenerator.generateLottos(numberOfLotto);
        Output.printLottoSixNumbers(lottos);
    }

    private int inputMoney() {
        while (true) {
            try {
                String money = Console.readLine();
                validateInputMoneyFormat(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateInputMoneyFormat(String money) {
        if (!money.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        if (!money.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 금액은 0으로 시작할 수 없습니다. (ex)5000");
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1장당 1000원입니다. 1000원 단위로 구매를 진행해주세요.");
        }
    }
}