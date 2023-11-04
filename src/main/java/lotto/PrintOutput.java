package lotto;

import java.util.List;

public class PrintOutput {

    public void printLottoPrice(int Num) {
        System.out.println(Num + "개를 구매했습니다.");
    }
    public void printLottoList(List<Integer> lotto) {
        System.out.println(lotto);
    }
    public void printResult(){
        System.out.println("당첨 통계\n---");
    }
}
