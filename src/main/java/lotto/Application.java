package lotto;
import java.util.Map;
import lotto.Lotto.LottoConstants;
import lotto.model.LottoGame;
import lotto.model.LottoPlayer;
import lotto.view.View;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        // 플레이어 인스턴스 생성
        LottoPlayer player = new LottoPlayer();

        // 구매 금액 입력 및 로또 구매
        int moneyInput = View.getPurchaseAmount();
        int numberOfPurchasedLottos = moneyInput / LottoConstants.LOTTO_PRICE.getPrice();
        player.purchaseLottos(numberOfPurchasedLottos);

        // 구매한 로또 출력
        View.printMyLotto(numberOfPurchasedLottos, player.getPurchasedLottos());

        // 당첨 번호 및 보너스 번호 입력
        List<Integer> winningNumbers = View.getWinningNumbers();
        int bonusNumber = View.getBonusNumber(winningNumbers);


        // 당첨금 계산 및 통계 업데이트
        Map<Integer, Integer> winningsStats = LottoGame.calculateWinningsStats(player.getPurchasedLottos(), winningNumbers, bonusNumber);
        player.updateTotalWinning(LottoGame.calculateTotalWinnings(winningsStats));

        // 수익률 계산
        double earningRate = player.getEarningRate();

        // 당첨 통계 및 수익률 출력
        View.printWinningStatistics(winningsStats, earningRate);


    }
}
