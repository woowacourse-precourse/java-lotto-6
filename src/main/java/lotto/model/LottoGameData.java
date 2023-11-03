package lotto.model;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.regex.Pattern;

public class LottoGameData {
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(String input) {
        patternCheck(input, Constants.MONEY_PATTERN, ErrorMessage.MONEY_ERROR);
        this.money=convert(input);
    }

    public void patternCheck(String input, Pattern pattern, ErrorMessage e) {
        if(!pattern.matcher(input).matches()){
            throw new IllegalArgumentException(e.getMessage()+ErrorMessage.MONEY_ERROR);
        }
    }

    public int convert(String input){
        return Integer.parseInt(input);
    }
}
