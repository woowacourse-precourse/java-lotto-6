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
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 양수여야 합니다.");
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식의 데이터를 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // 유효하지 않을 경우 재입력
        return inputPurchaseAmount();
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String[] winningNumberStrings = Console.readLine().split(",");
            if (winningNumberStrings.length != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
            List<Integer> winningNumbers = Arrays.stream(winningNumberStrings)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            new Lotto(winningNumbers); // 유효성 검사를 위해 Lotto 객체 생성
            return winningNumbers;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식의 데이터를 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // 유효하지 않을 경우 재입력
        return inputWinningNumbers();
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine().trim());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식의 데이터를 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // 유효하지 않을 경우 재입력
        return inputBonusNumber();
    }
}
