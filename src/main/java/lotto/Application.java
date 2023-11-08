//package lotto;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.function.BiFunction;
//import lotto.view.View;
//
//public class Application {
//
//
//    private static final int LOTTO_PRICE = 1000;
//    private static final Map<Integer, BiFunction<Integer, Boolean, Integer>> rankDecider = new HashMap<>();
//    private static final Map<Integer, Integer> prizeMoneyMap = new HashMap<>();
//
//    static {
//        rankDecider.put(6, (matches, bonus) -> 1);
//        rankDecider.put(5, Application::rankForFiveMatches);
//        rankDecider.put(4, (matches, bonus) -> 4);
//        rankDecider.put(3, (matches, bonus) -> 5);
//
//        prizeMoneyMap.put(1, 2000000000);
//        prizeMoneyMap.put(2, 30000000);
//        prizeMoneyMap.put(3, 1500000);
//        prizeMoneyMap.put(4, 50000);
//        prizeMoneyMap.put(5, 5000);
//    }
//
//
//
//    private static int calculateWinnings(Lotto lotto, List<Integer> winningNumbers, int bonusNumber, Map<Integer, Long> winningsMap) {
//        int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
//        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
//
//        int rank = rankDecider.getOrDefault(matchCount, (m, b) -> 0).apply(matchCount, hasBonus);
//
//        if (rank > 0) {
//            winningsMap.merge(rank, 1L, Long::sum);
//        }
//        return rank;
//    }
//
//
//    public static void main(String[] args) {
//
////        // 로또 구매 급액 입력 로직
////        System.out.println("로또를 구매할 금액을 입력하세요.");
////        int totalSpendings = View.getPurchaseAmount();
////
////        // 입력받은 금액으로 구매한 로또 갯수
////        int numberOfPurchasedLottos = totalSpendings / LOTTO_PRICE;
////        System.out.println(numberOfPurchasedLottos + "개를 구매했습니다.");
////
////        long totalWinnings = 0;
////
////        // 구매한 로또의 리스트
////        List<Lotto> purchasedLottos = new ArrayList<>();
////
////        // 당첨된 기록을 담을 hashmap
////        Map<Integer, Long> winningsMap = new HashMap<>();
////
////
////
////        // 구매한 갯수만큼 로또 생성
////        for (int i = 0; i < numberOfPurchasedLottos; i++) {
////            Lotto lotto = Lotto.generate();
////            purchasedLottos.add(lotto);
////            System.out.println(lotto.getNumbers());
////        }
////
////
////        List<Integer> winningNumbers;
////        int bonusNumber = 0;
////
////        // 당첨 번호 입력 로직
////        System.out.println("당첨 번호를 쉼표로 구분하여 입력하세요.");
////        winningNumbers = View.getWinningNumbers();
////
////
////        // 보너스 번호 입력 로직
////        System.out.println("보너스 번호를 입력하세요.");
////        bonusNumber = View.getBonusNumber(winningNumbers);
////        System.out.println("입력된 당첨 번호: " + winningNumbers + " + 보너스 번호: " + bonusNumber);
////
////
////        // 로또 당첨 계산 로직
////        for (Lotto lotto : purchasedLottos) {
////            int rank = calculateWinnings(lotto, winningNumbers, bonusNumber, winningsMap);
////            totalWinnings += prizeMoneyMap.getOrDefault(rank, 0);
////        }
////
////
////        double earningsRate = ((double) totalWinnings / totalSpendings) * 100;
////        earningsRate = Math.round(earningsRate * 100) / 100.0;
////
////
////        Map<Integer, String> rankDescriptionMap = Map.of(
////                1, "6개 일치 (2,000,000,000원)",
////                2, "5개 일치, 보너스 볼 일치 (30,000,000원)",
////                3, "5개 일치 (1,500,000원)",
////                4, "4개 일치 (50,000원)",
////                5, "3개 일치 (5,000원)"
////        );
////        // 등수별 당첨 결과 출력
////        rankDescriptionMap.forEach((rank, description) -> {
////            long count = winningsMap.getOrDefault(rank, 0L);
////            System.out.println(description + " - " + count + "개");
////        });
////
////        System.out.println("당신의 당첨 결과입니다:");
////        winningsMap.entrySet().stream()
////                .sorted(Map.Entry.comparingByKey())
////                .forEach(entry -> {
////                    if (entry.getValue() > 0) {
////                        System.out.println(entry.getKey() + "등을 " + entry.getValue() + "번 당첨, 총 상금: " + (prizeMoneyMap.get(entry.getKey()) * entry.getValue()) + "원");
////                    }
////                });
////
////        System.out.println("총 수익: " + totalWinnings + "원");
////        System.out.println("총 수익률은 " + earningsRate + "%입니다.");
////    }
////
////    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
////        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
////        uniqueNumbers.retainAll(winningNumbers);
////        return uniqueNumbers.size();
////    }
////
////
////    private static int rankForFiveMatches(Integer matches, Boolean bonus) {
////        if (bonus) {
////            return 2;
////        }
////        return 3;
////    }
//}
//


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
