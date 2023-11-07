package lotto.view;

import lotto.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class InputValidate {
    Repository repository;
    public InputValidate(Repository repository) {
        this.repository = repository;
    }
    public int lottoCountValidate(String amount){
        try {
            return validateCount(amount);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public List<Integer> lottoAnswerValidate(String lottoNum){
        List<Integer> answerLotto = new ArrayList<>();

        try{
            String[] temp = getLottoByString(lottoNum);
            for(String num : temp){
                answerLotto.add(isLottoNumber(validateIsDigit(num)));
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

        return answerLotto;
    }

    public int bonusNumValidate(String bonusNum){
        try{
            return checkBonusNumberInAnswer(isLottoNumber(validateIsDigit(bonusNum)));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    private int validateCount(String amount) throws IllegalArgumentException{
        int money = validateIsDigit(amount);
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액 형식이 1000원 단위가 아닙니다.");
        }
        return money/1000;
    }
    private int validateIsDigit(String inputValue){
        try{
            return Integer.parseInt(inputValue);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호나 금액의 경우 숫자만 입력 해야 합니다.");
        }
    }
    private int isLottoNumber(int value){
        if(value < 1 || value > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        return value;
    }
    private String[] getLottoByString(String lottoNum) {
        String[] splitLottoAnswer = lottoNum.split(",");
        if(splitLottoAnswer.length != 6){
            throw new IllegalArgumentException("[ERROR] 로또 개수는 6개 입니다.");
        }
        return splitLottoAnswer;
    }

    private int checkBonusNumberInAnswer(int bonus){
        List<Integer> lottoAnswer = repository.getAnswerLotto().getLottoDetail();
        if(lottoAnswer.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 로또 보너스 번호는 기본 번호 목록에 있으면 안됩니다.");
        }
        return bonus;
    }
}
