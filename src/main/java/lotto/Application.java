package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int PRICE_LOTTO = 1000;
        Console console = new Console();

        int purchaseAmount = getPurchaseAmount(console);
        int numberOfLottos = purchaseAmount / PRICE_LOTTO;

        List<Lotto> lottos =
    }

    private static int getPurchaseAmount(Console console) {
        int purchaseAmount;
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(console.readLine());
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }
}
