package lotto;

import static lotto.DrawResult.FIFTH_PRIZE;
import static lotto.DrawResult.FIRST_PRIZE;
import static lotto.DrawResult.FOURTH_PRIZE;
import static lotto.DrawResult.SECOND_PRIZE;
import static lotto.DrawResult.THIRD_PRIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.Mission;

public class LottoMission implements Mission {
    @Override
    public void run() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        PurchaseAmount purchaseAmount = new PurchaseAmount(UserInputReader.readPureNumber());
        System.out.println(purchaseAmount.getTicketQuantity() + "개를 구매했습니다.");
        LotteryPortfolio portfolio = new LotteryPortfolio();
        for (int i = 0; i < purchaseAmount.getTicketQuantity(); i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            portfolio.add(new Lotto(lottoNumbers));
            System.out.println(lottoNumbers);
        }
        System.out.println("당첨 번호를 입력해 주세요");
        Lotto winningLotto = new Lotto(UserInputReader.readMultiplePureNumbers());
        System.out.println("보너스 번호를 입력해 주세요");
        BonusNumber bonusNumber = new BonusNumber(winningLotto, UserInputReader.readPureNumber());
        System.out.println("당첨 통계\n---");
        LottoService service = new LottoService(winningLotto, bonusNumber);
        PortfolioReport report = service.analyzePortfolio(portfolio);
        StringBuilder reportView = new StringBuilder();
        reportView.append(String.format("%d개 일치 (%,d원) - %d개\n",
                FIFTH_PRIZE.getHitCount(), FIFTH_PRIZE.getWinnings(), report.getFifthPlaceCount()));
        reportView.append(String.format("%d개 일치 (%,d원) - %d개\n",
                FOURTH_PRIZE.getHitCount(), FOURTH_PRIZE.getWinnings(), report.getFourthPlaceCount()));
        reportView.append(String.format("%d개 일치 (%,d원) - %d개\n",
                THIRD_PRIZE.getHitCount(), THIRD_PRIZE.getWinnings(), report.getThirdPlaceCount()));
        reportView.append(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                SECOND_PRIZE.getHitCount(), SECOND_PRIZE.getWinnings(), report.getSecondPlaceCount()));
        reportView.append(String.format("%d개 일치 (%,d원) - %d개\n",
                FIRST_PRIZE.getHitCount(), FIRST_PRIZE.getWinnings(), report.getFirstPlaceCount()));
        reportView.append(String.format("총 수익률은 %.1f%%입니다.", report.getProfitRate()));
        System.out.println(reportView.toString());
    }
}
