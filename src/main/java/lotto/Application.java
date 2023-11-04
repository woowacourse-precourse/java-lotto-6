package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        ValidateInput validate = new ValidateInput();
        LottoNumberFactory factory = new LottoNumberFactory();

        System.out.println("구입금액을 입력해 주세요.");
        String tryCount = readLine();
        int lottoPrice = validate.validateLottoPrice(tryCount);

        System.out.println();
        System.out.println(lottoPrice+"개를 구매했습니다.");

        lottos = factory.makeLotto(lottoPrice);

        System.out.println();
        System.out.println("당첨 번호를 입력해주세요.");
        int[] winningNumbers = validate.validateWinningNumber(readLine());
        System.out.println();

        System.out.println("보너스 번호를 입력하세요.");
        int bonus = validate.validateBonus(readLine());
        System.out.println();

        Arrays.sort(winningNumbers);
        int total = 0;

        List<RankEnum> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
           RankEnum rank = lotto.checkRank(bonus, winningNumbers);
           ranks.add(rank);
        }

        List<RankEnum> first = ranks.stream().filter(s -> s == RankEnum.FIRST).toList();
        List<RankEnum> second = ranks.stream().filter(s -> s == RankEnum.SECOND).toList();
        List<RankEnum> third = ranks.stream().filter(s -> s == RankEnum.THIRD).toList();
        List<RankEnum> forth = ranks.stream().filter(s -> s == RankEnum.FORTH).toList();
        List<RankEnum> fifth = ranks.stream().filter(s -> s == RankEnum.FIFTH).toList();

        total = ranks.stream().mapToInt(Application::prize).sum();

        double profitRate = ((double) (total - lottoPrice * 1000) / (lottoPrice * 1000)) * 100;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5000원)" + fifth.size());
        System.out.println("4개 일치 (50000원)" + forth.size());
        System.out.println("5개 일치 (1,500,000원)" + third.size());
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)" + second.size());
        System.out.println("6개 일치 (2,000,000,000원)" + first.size());
        System.out.printf("총 수익률은 %.2f%% 입니다.\n", profitRate);
    }

    public static int prize(RankEnum rank){
        if (rank == RankEnum.FIRST) return 2000000000;
        if (rank == RankEnum.SECOND) return 30000000;
        if (rank == RankEnum.THIRD) return 1500000;
        if (rank == RankEnum.FORTH) return 50000;
        if (rank == RankEnum.FIFTH) return 5000;
        return 0;
    }
}
