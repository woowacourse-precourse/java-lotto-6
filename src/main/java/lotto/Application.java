package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            int lottoCount = purchaseAmount / 1000;
            LottoGame game = new LottoGame(lottoCount);

            game.printLottoTickets();

            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber();
            game.checkWinning(winningNumbers, bonusNumber);

            game.printStatistics();
            game.calculateProfitRate(purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // 에러 발생 시 재입력 받거나 프로그램을 종료할 수 있습니다.
        }
    }
    // 로또 구매 금액 입력, 당첨 번호 입력, 보너스 번호 입력 등의 메소드 구현
    private static int inputPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("유효하지 않은 구매 금액입니다.");
        }
        return purchaseAmount;
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStrings = Console.readLine().split(",");
        if (winningNumberStrings.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        return Arrays.stream(winningNumberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }
}
