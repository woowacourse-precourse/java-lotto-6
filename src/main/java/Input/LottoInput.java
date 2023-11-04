package Input;

import validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoInput {
    public static List<Integer> makeAnswerNumber() throws IllegalArgumentException {
        String ans = readLine();
        String[] split = ans.split(",");
        Validator.checkAnswerNumber(split);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            answer.add(Integer.parseInt(split[i]));
        }
        Validator.checkDuplication(answer);
        return answer;
    }

    public static int makeBonusNumber() throws IllegalArgumentException {
        String bonusString = readLine();
        Validator.checkBonusNumber(bonusString);
        int bonus = Integer.parseInt(bonusString);
        return bonus;
    }

    public static int inputPrice() throws IllegalArgumentException{
        String priceString=readLine();
        Validator.checkPrice(priceString);
        int price=Integer.parseInt(priceString);
        return price;
    }
}
