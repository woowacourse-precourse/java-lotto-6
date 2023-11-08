package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String WINNING_RATE = "\n당첨 통계 \n---\n";
    private static final String RATE_OF_RETURN = "총 수익률은 ";

    /**
     * 구입금액 입력하는 뷰
     */
    public void purchaseCount(long purchase){
        System.out.println("\n"+purchase + PURCHASE_COUNT);
    }


    /**
     * 랜덤으로 생성한 로또번호를 출력하는 뷰
     */
    public void randomLottoNumber(List<Integer> list){
        System.out.println(list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]")));
    }

    /**
     * 당첨 통계 시작 출력문을 보여주는 뷰
     */
    public void winningStatics(){
        System.out.print(WINNING_RATE);
    }


    /**
     * 당첨 통계를 출력하는 뷰
     */
    public void winningRate(String message, int matchNumber){
        System.out.println(message + matchNumber + "개");
    }


    /**
     * 수익률을 출력하는 뷰
     */
    public void rateOfReturn(double rate){
        System.out.println(RATE_OF_RETURN + String.format("%.1f",rate) + "%입니다.");
    }

}
