package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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
}
