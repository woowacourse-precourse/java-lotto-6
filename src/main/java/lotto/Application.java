package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoManager = new LottoManager();

        final int price = readPrice();

        User user = new User(price);

        lottoManager.printLottos(user);
        Lotto lotto = lottoManager.createUserNumbers();

        user.setUserLotto(lotto);

        lottoManager.bonusNumberInput(user);

        lottoManager.printWinningResult(user);

        lottoManager.getYield(user, price);
    }

    private static int readPrice() {
        int price = 0;
        boolean errorFlag = true;

        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            final String input = Console.readLine();

            try {
                price = LottoManager.priceInput(input);
                errorFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (!errorFlag) {
                return price;
            }
        }
    }
}