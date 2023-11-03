package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoManager {

    private int price;

    public void start() {
        boolean validateFlag = false;

        while (!validateFlag) {
            try {
                priceInput();
                validateFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(String input) {
        int price = numberFormatValidate(input);
        unitValidate(price);

        this.price = price;
    }

    public void priceInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        setPrice(input);
    }

    private int numberFormatValidate(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[error] 숫자를 입력해주십시오.");
        }

        return number;
    }

    private void unitValidate (int price) {
        if (price < Const.priceUnit || price % Const.priceUnit != 0) {
            throw new IllegalArgumentException("[error] " + Const.priceUnitOutput + " 단위의 금액을 입력해주십시오.");
        }
    }

    public void printLottos(User user) {
        System.out.println(user.getLottoCount() + "개를 구매했습니다.");
        List<Lotto> lottos = user.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
