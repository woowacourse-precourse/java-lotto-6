package lotto.controller.inputvalidate;

import lotto.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class InputValidateAnswer extends InputValidate{

    public List<Integer> lottoAnswerValidate(String lottoNum){
        List<Integer> answerLotto = new ArrayList<>();

        try{
            String[] temp = getLottoByString(lottoNum);
            for(String num : temp){
                answerLotto.add(super.isLottoNumber(validateIsDigit(num)));
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

        return answerLotto;
    }
    private String[] getLottoByString(String lottoNum) {
        return lottoNum.split(",");
    }
}
