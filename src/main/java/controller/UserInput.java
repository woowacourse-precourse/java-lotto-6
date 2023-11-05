package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Purchase;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    //사용자 인풋을 담당하는 클래스
    //객체 생성이 필요 없다.

    public static int purchasePrice(){
        int price = Integer.parseInt(Console.readLine());
        return price;
    }
    static List<Integer> prizeNumber(){
        List<Integer> test = new ArrayList<>();
        return test;
    }
    static int bonusNumber(){
        int test = 1;
        return test;
    }
}
