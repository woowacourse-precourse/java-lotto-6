package lotto.player;

import lotto.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.MessageConstant.BUYMESSAGE;
import static lotto.constants.NumConstant.PRICE;

public class Wallet {
    private List<Lotto> lottos = new ArrayList<>();
    private int buyMoney;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getBuyMoney() {
        return buyMoney;
    }

    public void printMyLotto() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoInfo());
        }
    }

    public void inputBuyMoney() {
        System.out.println(BUYMESSAGE);
        String input;
        input = readLine();
        validateMoney(input);
        buyMoney = Integer.parseInt(input);
        System.out.println();
    }

    public void validateMoney(String input) {
        checkChar(input);
        int money = Integer.parseInt(input);
        if (money % PRICE.getValue() != 0)
            throw new IllegalArgumentException("[ERROR] " + PRICE.getValue() + "원 단위로 입력해주세요");
        if (money == 0) throw new IllegalArgumentException("[ERROR] 금액을 입력해 주세요");
    }

    public void checkChar(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9')
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
    }
}
