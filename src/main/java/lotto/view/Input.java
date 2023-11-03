package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    InputValidate inputValidate = new InputValidate();
    public int getLottoCount(){
        return inputValidate.lottoCountValidate(Console.readLine());
    }

    public List<Integer> getLottoAnswerNum(){
        return inputValidate.lottoAnswerValidate(Console.readLine());
    }

    public int getBonusNum(){
        return inputValidate.bonusNumValidate(Console.readLine());
    }

}
