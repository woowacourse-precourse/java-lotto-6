package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.inputvalidate.InputValidate;
import lotto.controller.inputvalidate.InputValidateAnswer;
import lotto.controller.inputvalidate.InputValidateBonus;
import lotto.controller.inputvalidate.InputValidateMoney;
import lotto.repository.Repository;

import java.util.List;

public class Input {
    InputValidateMoney inputValidateMoney;
    InputValidateAnswer inputValidateAnswer;
    InputValidateBonus inputValidateBonus;
    public Input(Repository repository) {
        inputValidateMoney = new InputValidateMoney();
        inputValidateAnswer = new InputValidateAnswer();
        inputValidateBonus = new InputValidateBonus(repository);
    }
    public int getLottoCount(){
        return inputValidateMoney.lottoCountValidate(Console.readLine());
    }

    public List<Integer> getLottoAnswerNum(){
        return inputValidateAnswer.lottoAnswerValidate(Console.readLine());
    }

    public int getBonusNum(){
        return inputValidateBonus.bonusNumValidate(Console.readLine());
    }

}
