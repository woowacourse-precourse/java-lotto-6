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
        }
    }

    private static int inputPurchaseAmount() {
        while (true) {
            System.out.println("구매 금액을 입력해 주세요.");
            try {
                int purchaseAmount = readPurchaseAmount();
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식의 데이터를 입력해 주세요.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 양수여야 합니다.");
        }
    }

    private static List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                return parseWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        String[] winningNumberStrings = input.split(",");
        if (winningNumberStrings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> winningNumbers = Arrays.stream(winningNumberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        new Lotto(winningNumbers); // 유효성 검사를 위해 Lotto 객체 생성
        return winningNumbers;
    }

    private static int inputBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                return readAndValidateBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readAndValidateBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine().trim());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식의 데이터를 입력해 주세요.");
        }
    }

}
