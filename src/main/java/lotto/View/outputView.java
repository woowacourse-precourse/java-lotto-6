package lotto.View;

import java.util.List;

public class outputView {
    public static void displayLottoCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public void displayLottoNumberList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }


}
