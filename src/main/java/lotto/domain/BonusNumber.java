package lotto.domain;

import lotto.utils.Parser;

public class BonusNumber {
    int bonusNumber;

    public BonusNumber(String userInput){
        this.bonusNumber = Parser.parseStringToInt(userInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
