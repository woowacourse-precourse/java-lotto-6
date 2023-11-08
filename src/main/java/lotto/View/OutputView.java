package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.PrizeMoney;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {


    public static void printInputMessage(String message) {
        System.out.println(message);
    }

    public static void printInputException(String message) {
        System.out.println(message);
    }

    public static void printNewLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for( Lotto lotto : lottos ) {
            printNewLotto(lotto);
        }
    }

    private static void printNewLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for ( int i = 0; i < numbers.size(); i++ ){
            if( i == numbers.size() - 1 ){
                System.out.print(numbers.get(i));
                break;
            }
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println("]");
    }

    public static void printMatchingCount(List<Integer> matchingCount) {

        DecimalFormat df = new DecimalFormat("###,###");

        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (" + df.format(PrizeMoney.FIFTH.getValue()) + "원) - " + matchingCount.get(0) + "개");
        System.out.println("4개 일치 (" + df.format(PrizeMoney.FOURTH.getValue()) + "원) - " + matchingCount.get(1) + "개");
        System.out.println("5개 일치 (" + df.format(PrizeMoney.THIRD.getValue()) + "원) - " + matchingCount.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(PrizeMoney.SECOND.getValue()) + "원) - " + matchingCount.get(3) + "개");
        System.out.println("6개 일치 (" + df.format(PrizeMoney.FIRST.getValue()) + "원) - " + matchingCount.get(4) + "개");
    }

    public static void printEarningRate(double earningRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningRate));

    }
}
