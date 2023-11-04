package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class LottoGame {
    private LottoGameService lottoGameService;

    public LottoGame() {
        this.lottoGameService = new LottoGameService();
    }

    public void start() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        LottoGameResponse lottoGameResponse = lottoGameService.buy(money);

        System.out.printf("%s개를 구매했습니다.\n", lottoGameResponse.getCount());
        for (int i = 0; i < lottoGameResponse.getCount(); i++) {
            System.out.println(lottoGameResponse.getBuyLottoNumbers().get(i));
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        Map<LottoRank, Integer> result = lottoGameService.calculateResult(winningNumbers, bonusNumber);
        printResult(result);
    }

    private void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개\n", result.getOrDefault(LottoRank.FIFTH_RANK, 0));
        System.out.printf("4개 일치 (50,000원) - %s개\n", result.getOrDefault(LottoRank.FOURTH_RANK, 0));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n", result.getOrDefault(LottoRank.THIRD_RANK, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n", result.getOrDefault(LottoRank.SECOND_RANK, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n", result.getOrDefault(LottoRank.FIRST_RANK, 0));
        System.out.println("총 수익률은 62.5%입니다.");
    }
}
