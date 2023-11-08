package lotto;

import util.ErroerMessage;
import util.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private int money;
    private LottoWithBounusNumber lotto;

    User(LottoWithBounusNumber lotto, int money) {
        this.lotto = lotto;
        this.money = money;
    }

    public static User createUser() {
        int money;
        LottoWithBounusNumber lotto;
        while (true){
            try {
                money = inputMoney();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]"+e.getMessage());
            }
        }
        lotto = LottoWithBounusNumber.createLottoWithBonusNumber();
        return new User(lotto, money);
    }

    private static int inputMoney() {
        String unCheckedMoney;
        InputView.printUserMoney();
        unCheckedMoney = readLine();
        if (unCheckedMoney.matches("^[a-zA-Z]*$")) throw new IllegalArgumentException(ErroerMessage.ONLY_NUMBER_INPUT_MONEY);
        else if ((Integer.parseInt(unCheckedMoney) % 1000) > 0) throw new IllegalArgumentException(ErroerMessage.ONLY_THOUSANDS_INPUT_MONEY);
        else return Integer.parseInt(unCheckedMoney);
    }

    public int getMoney() {
        return money;
    }
    public LottoWithBounusNumber getLotto() {
        return lotto;
    }
}
