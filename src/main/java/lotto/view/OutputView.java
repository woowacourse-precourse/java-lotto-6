package lotto.view;

import java.util.List;

public class OutputView {

    public void printCount(int count){
        System.out.println( count + "개를 구매했습니다");
    }

    public void printLottos(List<Integer> nums){
        System.out.println(nums);
    }

}
