package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private int price;

    public void start() {
        try {
            priceInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            start();
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

    public Lotto createUserNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splitNumbers = Console.readLine().replaceAll(" ", "").split(",");

        try {
            return createLotto(splitNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return createUserNumbers();
        }
    }

    public Lotto createLotto(String[] splitNumbers) {
        List<Integer> userNumbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            int number = numberFormatValidate(splitNumber);
            arrangeValidate(number);

            userNumbers.add(number);
        }

        return Lotto.createUserNumbers(userNumbers);
    }

    private void arrangeValidate(int number) {
        if (Const.winningRangeStartNumber > number || Const.winningRangeEndNumber < number) {
            throw new IllegalArgumentException("[error] 숫자의 범위는 1~45 입니다.");
        }
    }
}
