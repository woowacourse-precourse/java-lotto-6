package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View {
    private static final int FAIL_PRIZE_NUM = 0;
    private static final int BONUS_PRIZE = 30_000_000;

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    private static final String OUTPUT_PURCHASED_LOTTO_NUMBERS = "개를 구매했습니다.";
    private static final String OUTPUT_PRIZE_RESULT_MENT = "당첨 통계\n---";
    private static final String OUTPUT_PRIZE_RESULT_1 = "개 일치";
    private static final String OUTPUT_PRIZE_RESULT_BONUS = ", 보너스 볼 일치";
    private static final String OUTPUT_RATE_RETURN_1 = "총 수익률은 ";
    private static final String OUTPUT_RATE_RETURN_2 = "%입니다.";


    DecimalFormat formatter = new DecimalFormat("###,###");


    public void request_InputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public void request_InputWinLottoNumbers() {
        System.out.println(INPUT_WIN_LOTTO_NUMBERS);
    }

    public void request_InputBonusNumbers() {
        System.out.println(INPUT_BONUS_NUMBERS);
    }


    public void print_PurchasedLottoNumbers(int purchasedLottoNum) {
        System.out.println(purchasedLottoNum + OUTPUT_PURCHASED_LOTTO_NUMBERS);
    }

    public void print_purchasedLotto(List<Lotto> purchasedLotto) {
        purchasedLotto.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    //결과 통계 출력
    public void printHittingResult(HashMap<Rank, Integer> map) {
        System.out.println(OUTPUT_PRIZE_RESULT_MENT);
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .filter(e -> e.getKey().getWinningMoney() != FAIL_PRIZE_NUM)
                .forEach(e -> printResult(map.get(e.getKey()),e.getKey().getCountOfMatch(),e.getKey().getWinningMoney()));
    }

    public void printResult(int totalCount, int countOfMatch, int winningMoney) {
        System.out.print(countOfMatch + OUTPUT_PRIZE_RESULT_1);
        if (winningMoney == BONUS_PRIZE) {
            System.out.print(OUTPUT_PRIZE_RESULT_BONUS);
        }
        System.out.println(" (" + formatter.format(winningMoney) + "원) - " + totalCount + "개");
    }

    //총 수익률 출력
    public void printProfitResult(int totalHitMoney, int money) {
        String rateReturn = String.format("%.1f",totalHitMoney / (double) money * 100.0);

        System.out.println(OUTPUT_RATE_RETURN_1 + rateReturn+OUTPUT_RATE_RETURN_2);
    }



    public void print_Exception(String errorMessage) {
        System.out.println(errorMessage);
    }
}
