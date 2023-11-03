package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoManager {

    private final int price;

    public LottoManager(String input) {
        int price = numberFormatValidate(input);
        unitValidate(price);

        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static LottoManager priceInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return new LottoManager(input);
    }

    private int numberFormatValidate(String input) {
        int price;

        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[error] 숫자를 입력해주십시오.");
        }

        return price;
    }

    private void unitValidate (int price) {
        if (price < Const.priceUnit || price % Const.priceUnit != 0) {
            throw new IllegalArgumentException("[error] " + Const.priceUnitOutput + " 단위의 금액을 입력해주십시오.");
        }
    }
}
