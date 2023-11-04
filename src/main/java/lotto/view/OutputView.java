package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String LOTTO_COUNT_PRINT_MESSAGE = "개를 구매했습니다.";

    /**
     * 3. 발급한 로또 번호 출력 기능
     */
    static private void printOutputMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.print(lottoCount);
        printOutputMessage(LOTTO_COUNT_PRINT_MESSAGE);
    }

    public static void printCurrentLottoList(Lotto lotto) {
        System.out.print("[");
        List<Integer> lotto_num_list = lotto.getNumbers();

        //-> 문자열로 변환해서
        List<String> lotto_str_num = lotto_num_list.stream()
                .map(String::valueOf)
                .toList();

        System.out.print(String.join(", ", lotto_str_num));
        System.out.print("]");
        System.out.println();
    }


    /**
     * 결과 출력
     */
    public static void printResultLottoPrize(Map<Rank, Integer> rankIntegerMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : rankIntegerMap.keySet()) {
            if (rank == Rank.UNRANK) {
                continue;
            }
            
            int count = rankIntegerMap.get(rank);
            System.out.println(rank.getOutputMessage() + count + "개");
        }
    }

    /**
     * 백분위 수익률 출력
     */
    public static void printPrizePercentResult(double out) {
        System.out.print("총 수익률은 " + out + "%" + "입니다.");
    }


}
