package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinLottoResult;

public class OutputView {
    private final String LOTTO_COUNT_PRINT_MESSAGE = "개를 구매했습니다.";

    /**
     * 3. 발급한 로또 번호 출력 기능
     */
    static private void printOutputMessage(String message) {
        System.out.println(message);
    }

    public void printLottoCount(int lottoCount) {
        System.out.print(lottoCount);
        printOutputMessage(LOTTO_COUNT_PRINT_MESSAGE);
    }

    public void printCurrentLottoList(Lotto lotto) {
        System.out.print("[");
        List<Integer> lotto_num_list = lotto.getNumbers();
        //-> 문자열로 변환해서
        List<String> lotto_str_num = lotto_num_list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", lotto_str_num));
        System.out.print("]");
        System.out.println();
    }


    /**
     * 결과 출력
     */
    public void printResultLottoPrize(WinLottoResult winLottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinLottoResult ans : winLottoResult.values()) {
            if (ans.getName().equals("three")) {
                System.out.println("3개 일치 (5,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("four")) {
                System.out.println("4개 일치 (50,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("five")) {
                System.out.println("5개 일치 (1,500,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("six")) {
                System.out.println("6개 일치 (2,000,000,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("five_bonus")) {
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ans.getCount() + "개");
            }
        }
    }

    /**
     * 백분위 수익률 출력
     */
    public void printPrizePercentResult(double out) {
        System.out.print("총 수익률은 " + out + "%" + "입니다.");
    }


}
