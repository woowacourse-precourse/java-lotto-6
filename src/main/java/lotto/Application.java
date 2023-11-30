package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            validatePurchaseAmount(purchaseAmount);
            LottoGame lottoGame = new LottoGame(purchaseAmount);
            lottoGame.printLottos();


            System.out.println("당첨 번호를 입력해 주세요.");
            String[] winningNumbersInput = Console.readLine().split(",");
            List<Integer> winningNumbers = parseNumbers(winningNumbersInput);

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());

            Lotto winningLotto = new Lotto(winningNumbers);
            WinningResult winningResult = lottoGame.checkResults(winningLotto, bonusNumber);

            // 당첨 결과 출력
            System.out.println("당첨 통계");
            System.out.println("---------");
            winningResult.printResult();

            // 수익률 계산 및 출력
            double earningsRate = lottoGame.calculateEarningsRate(winningResult);
            System.out.println("총 수익률은 " + String.format("%.1f", earningsRate) + "%입니다.");

        }catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> parseNumbers(String[] numbersInput) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersInput) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }
}
