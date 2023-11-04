package lotto.Input;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static List<Integer> makeAnswerNumber() {
        String ans = readLine(); //예외 필요
        List<Integer> answer = new ArrayList<>();
        String[] split = ans.split(",");
        String[] a=new String[]{"1","2","3","4"};
        for (int i = 0; i < split.length; i++) {
            answer.add(Integer.parseInt(split[i]));
        }
        return answer;
    }
    public static int makeBonusNumber(){
        int bonus;
        try{
            bonus=Integer.parseInt(readLine());
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
        return bonus;
    }

}
