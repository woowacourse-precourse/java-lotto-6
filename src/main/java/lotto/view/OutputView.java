package lotto.view;

import lotto.model.Number;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printBoughtLotto(int count, List<Number> buyedLotto){
        System.out.println(count + "개를 구매했습니다.");
        for(Number number:buyedLotto){
            System.out.println(number.getNumberList());
        }
    }

}
