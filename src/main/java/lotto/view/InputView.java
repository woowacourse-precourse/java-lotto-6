package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int moneyInput(){
        int lottoNum=0;
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(readLine().trim());
            lottoNum= money/1000;
        } catch (NumberFormatException error) {
            System.out.println("[ERROR] 올바른 형식의 입력값이 아닙니다. 다시 입력해 주십시오.");
        }
        return lottoNum;
    }

    public  List<Integer> answerInput(){
        List<Integer> convertAnswer = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String[] answer = readLine().split(",");
            StringToInt(answer,convertAnswer);
        } catch (NumberFormatException error) {
            System.out.println("[ERROR] 올바른 형식의 입력값이 아닙니다. 다시 입력해 주십시오.");
        }
        return convertAnswer;
    }
    private void StringToInt(String[] strList, List<Integer> intList){
        for(String s : strList) intList.add(Integer.valueOf(s));
    }
    public int bonusInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine().trim());
    }
}
