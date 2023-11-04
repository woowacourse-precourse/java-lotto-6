package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();

        final int price = readPrice();

        User user = new User(price);

        printLottos(user);

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

    private static void printLottos(User user) {
        System.out.println(user.getLottoCount() + "개를 구매했습니다.");
        List<Lotto> lottos = user.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}