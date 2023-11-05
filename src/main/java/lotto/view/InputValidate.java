package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputValidate {

    public int lottoCountValidate(String amount){
        try {
            return validateCount(amount);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 구매 금액 형식이 맞지 않습니다.");
        }
        return 0;
    }
    public List<Integer> lottoAnswerValidate(String lottoNum){
        List<Integer> answerLotto = new ArrayList<>();

        try{
            String[] temp = getLottoByString(lottoNum);
            for(String num : temp){
                try {
                    answerLotto.add(validateIsDigit(num));
                }catch (IllegalArgumentException e){
                    System.out.println("[ERROR] 로또 번호 형식이 맞지 않습니다.");
                    return new ArrayList<>();
                }
            }
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호 형식이 맞지 않습니다.");
        }

        return answerLotto;
    }

    public int bonusNumValidate(String bonusNum){
        try{
            return validateIsDigit(bonusNum);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 구매 금액 형식이 맞지 않습니다.");
        }
        return 0;
    }
    private int validateCount(String amount) throws IllegalArgumentException{
        int money = validateIsDigit(amount);
            if(money % 1000 != 0){
                throw new IllegalArgumentException();
            }
        return money;
    }
    private int validateIsDigit(String inputValue) throws IllegalArgumentException{
        return Integer.parseInt(inputValue);
    }
    private String[] getLottoByString(String lottoNum) {
        String[] splitLottoAnswer = lottoNum.split(",");
        if(splitLottoAnswer.length != 6){
            throw new IllegalArgumentException();
        }
        return splitLottoAnswer;
    }
}
