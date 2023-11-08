package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        public static void main(String[] args) {
            try {
                int purchaseAmount = getInputAmount();
                LottoGame game = new LottoGame(purchaseAmount);
                game.printLottos();

                List<Integer> winningNumbers = getWinningNumbers();
                int bonusNumber = getBonusNumber();

                game.checkResults(winningNumbers, bonusNumber);
                System.out.printf("총 수익률은 %.1f%%입니다.", game.calculateProfit());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        private static int getInputAmount() {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                int amount = Integer.parseInt(input);
                if (amount <= 0 || amount % LottoGame.PRICE_PER_LOTTO != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
            }
        }

        private static List<Integer> getWinningNumbers() {

        }

        private static int getBonusNumber() {

        }
    }
}
