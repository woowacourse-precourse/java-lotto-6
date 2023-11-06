package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningRate;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String WINNING_RATE = "당첨 통계 \n---";
    private static final String RATE_OF_RETURN = "총 수익률은 ";


    public void purchaseCount(long purchase){
        System.out.println("\n"+purchase + PURCHASE_COUNT);
    }

    public void randomLottoNumber(List<Integer> list){
        System.out.println(list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]")));
    }

    public void winningStatics(){
        System.out.print(WINNING_RATE);
    }

    public void winningRate(String message, int matchNumber){

        System.out.println(message + matchNumber + "개");
    }

    public void rateOfReturn(double rate){

        System.out.println(RATE_OF_RETURN + String.format("%.1f",rate) + "%입니다.");
    }

}
