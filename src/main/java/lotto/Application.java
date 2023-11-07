package lotto;

import camp.nextstep.edu.missionutils.*;
import lotto.domain.enums.Rank;

import java.util.*;


public class Application {

    static Map<Rank, Integer> createLottoRanksMap(List<Integer> winningNumber, List<Lotto> lottos, int bonusNumber) {
        Map<Rank, Integer> lottoRanks = new HashMap<>();
        //map 초기화
        lottoRanks.put(Rank.NOT, 0);
        lottoRanks.put(Rank.FIFTH, 0);
        lottoRanks.put(Rank.FOURTH, 0);
        lottoRanks.put(Rank.THIRD, 0);
        lottoRanks.put(Rank.SECOND, 0);
        lottoRanks.put(Rank.FIRST, 0);

        for (int i = 0; i < lottos.size(); i++) {
            Rank rank = Lotto.judgeLottoRank(winningNumber, lottos.get(i), bonusNumber);
            lottoRanks.put(rank, lottoRanks.get(rank) + 1);
        }
        return lottoRanks;
    }

    static double computeRateOfReturn(Map<Rank, Integer> lottoRanks, long purchaseAmount) {
        long proceeds;
        proceeds = lottoRanks.get(Rank.FIFTH) * 5000 + lottoRanks.get(Rank.FOURTH) * 50000 + lottoRanks.get(Rank.THIRD) * 1500000 + lottoRanks.get(Rank.SECOND) * 30000000 + lottoRanks.get(Rank.FIRST) * 2000000000;
        return (double) proceeds / purchaseAmount * 100;
    }

    static void printResult(Map<Rank, Integer> lottoRanks, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoRanks.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoRanks.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoRanks.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 불 일치 (30,000,000원) - %d개\n", lottoRanks.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoRanks.get(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다\n", Math.round(rateOfReturn * 100.) / 100.);
    }

    static long getPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            long purchaseAmount = Integer.parseInt(Console.readLine());
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000의 배수여야 합니다.");
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

    public static void game() {
        long purchaseAmount = getPurchaseAmount();

        //1000의 배수라면 구입한 로또의 개수 출력
        System.out.println(String.format("%d개를 구매했습니다.", purchaseAmount / 1000));
        //로또 생성 + 출력
        List<Lotto> lottos = Lotto.createLottos(purchaseAmount / 1000);

        //당첨 번호 입력 받기
        // ,로 분리되지 않는 경우
        // 문자만 입력한 경우
        // 6개의 수를 입력하지 않은 경우

        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winningNumberOfString = List.of(Console.readLine().split(","));
        List<Integer> winningNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumber.add(Integer.parseInt(winningNumberOfString.get(i)));
        }
        System.out.println(winningNumber);

        //보너스 번호 입력 받기
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println(bonusNumber);

        Map<Rank, Integer> lottoRanks = createLottoRanksMap(winningNumber, lottos, bonusNumber);

        double rateOfReturn = computeRateOfReturn(lottoRanks, purchaseAmount);

        //당첨 통계 출력
        printResult(lottoRanks, rateOfReturn);
    }

    public static void main(String[] args) {
        game();
    }
}
