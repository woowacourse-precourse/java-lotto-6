package lotto.controller.inputvalidate;

import lotto.repository.Repository;

import java.util.List;

public class InputValidateBonus extends InputValidate{
    Repository repository;
    public InputValidateBonus(Repository repository) {
        this.repository = repository;
    }

    public int bonusNumValidate(String bonusNum){
        try{
            return checkBonusNumberInAnswer(isLottoNumber(validateIsDigit(bonusNum)));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int checkBonusNumberInAnswer(int bonus){
        List<Integer> lottoAnswer = repository.getAnswerLotto().getLottoDetail();
        if(lottoAnswer.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 로또 보너스 번호는 기본 번호 목록에 있으면 안됩니다.");
        }
        return bonus;
    }
}
