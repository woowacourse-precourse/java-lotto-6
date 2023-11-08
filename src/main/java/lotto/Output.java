package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Output {

    static int ticket;

    public static void outputLotto(){
        for(List<Integer> number : outputNumbers(ticket)){
            Collections.sort(number);
            Lotto lotto = new Lotto(number);
            System.out.println((number));
        }
        System.out.println();
    }

    public static void outputPurchase(){
        int money = Input.inputMoney();
        System.out.println("\n"+money/1000+"개를 구매했습니다.");
        ticket = money / 1000;
    }

    public static List<List<Integer>> outputNumbers(int count){
        List<List<Integer>> numbers = new ArrayList<>();
        for(int i = 0; i<count; i++){
            numbers.add(Input.inputNumbers());
        }
        return numbers;
    }
}
