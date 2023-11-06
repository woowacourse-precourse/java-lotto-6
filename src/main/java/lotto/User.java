package lotto;

import camp.nextstep.edu.missionutils.Console;

import  java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class User {

    static List<Integer> userLotto = new ArrayList<>();
    static int bonusNumber;

    public static void InputLottoNumber(){

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
    // TODO: input이 숫자6개가 ,로 되어있는지, 1~45까지인지, 숫자와 컴마로만 이루어져있는지, 중복이 없는지 확인
        String[] userInput = input.split(",");
        for(String inputParsing : userInput){

            int number = Integer.parseInt(inputParsing);
            userLotto.add(number);

        }
        Collections.sort(userLotto);
        System.out.println(userLotto);

    }

    public  static void InputBonusNumber(){

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");
        String inputBonus = Console.readLine();
        // TODO: 1~45의 정수 입력하는지 확인하기
        bonusNumber = Integer.parseInt(inputBonus);

    }

}
