package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int PRICE_OF_LOTTO = 1000;

    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int numberOfLottos = purchaseAmount / PRICE_OF_LOTTO;

        List<Lotto> lottos = purchaseLottos(numberOfLottos);
        printLottos(lottos);

        Lotto winningLotto = inputWinningLotto();
        int bonusNumber = inputBonusNumber(winningLotto);
        LottoResult lottoResult = checkResults(lottos, winningLotto, bonusNumber);

        lottoResult.printResult();
    }

    private static int inputPurchaseAmount() {
        int purchaseAmount = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount <= 0 || purchaseAmount % PRICE_OF_LOTTO != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수로 입력해야 합니다.");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static List<Lotto> purchaseLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(LottoMachine.drawLotto()));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private static Lotto inputWinningLotto() {
        Lotto winningLotto = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] winningNumbers = Console.readLine().split(",");
                List<Integer> numbers = new ArrayList<>();
                for (String number : winningNumbers) {
                    int parsedNumber = Integer.parseInt(number.trim());
                    if (parsedNumber < 1 || parsedNumber > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    numbers.add(parsedNumber);
                }
                winningLotto = new Lotto(numbers);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    private static int inputBonusNumber(Lotto winningLotto) {
        int bonusNumber = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine().trim());
                if (winningLotto.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private static LottoResult checkResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        LottoResult lottoResult = new LottoResult(lottos.size() * PRICE_OF_LOTTO);
        for (Lotto lotto : lottos) {
            Rank rank = LottoEvaluator.evaluate(lotto, winningLotto, bonusNumber);
            lottoResult.addWinningRank(rank);
        }
        return lottoResult;
    }
}
