//package lotto;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//import lotto.controller.LottoController;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class ProcedureTest {
//    @DisplayName("일치하는 개수가 5개이고, 보너스 번호가 일치하면 5.5(2등) 반환")
//    @Test
//    void testCheckBonusNumber() {
//        LottoController lottoProcedure = new LottoController();
//        double count = 5;
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
//        int bonusNumber = 6;
//        double result = lottoProcedure.checkBonusNumber(numbers);
//        assertEquals(5.5, result);
//    }
//
//    @DisplayName("일치하는 개수를 계산해서, 등수를 확인한다.")
//    @Test
//    void testCalculateRank() {
//        LottoController lottoProcedure = new LottoController();
//        List<Double> counts = List.of(6.0, 5.5, 5.0, 4.0, 3.0);
//        for (int i = 0; i < counts.size(); i++) {
//            int rank = lottoProcedure.calculateRank(counts.get(i));
//            assertEquals(i + 1, rank);
//        }
//    }
//
//    @DisplayName("각 등수를 한 횟수를 확인하여 총 상금을 구한다.")
//    @Test
//    void testCalculateResult() {
//        LottoController lottoProcedure = new LottoController();
//        double result = 0;
//        List<Integer> rankCount = List.of(0, 1, 1, 1, 1, 1);
//        List<Double> reward = List.of(0.0, 200000000.0, 30000000.0, 1500000.0, 50000.0, 5000.0);
//
//        for (int i = 0; i < rankCount.size(); i++) {
//            result += rankCount.get(i) * reward.get(i);
//        }
//        assertEquals(231555000.0, result);
//    }
//
//    @DisplayName("당첨 번호와 구입한 로또의 번호가 일치하면 count를 올린다.")
//    @Test
//    void testIncreaseCount() {
//        List<List<Integer>> purchasedLottoNumber = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12));
//        List<Integer> winningNumber = List.of(6, 5, 4, 3, 2, 1);
//        double count = 0;
//
//        for (int i = 0; i < purchasedLottoNumber.size(); i++) {
//            for (int j = 0; j < 6; j++) {
//                if (purchasedLottoNumber.get(i).contains(winningNumber.get(j))) {
//                    count += 1;
//                }
//            }
//        }
//
//        assertEquals(count, 6);
//    }
//}
