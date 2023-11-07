package Input;

import lotto.Lotto;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static constants.MessageType.COMMA;

public class LottoInput {
    public static List<Integer> makeAnswerNumber() throws IllegalArgumentException {
        String ans = readLine();
        String[] split = ans.split(COMMA.getMessage());
        Validator.checkAnswerNumber(split);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            answer.add(Integer.parseInt(split[i]));
        }
        Validator.checkDuplication(answer);
        return answer;
    }

    public static int makeBonusNumber(Lotto answer) throws IllegalArgumentException {
        String bonusString = readLine();
        Validator.checkBonusNumber(bonusString,answer);
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
