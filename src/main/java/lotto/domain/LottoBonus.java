package lotto.domain;

import java.util.List;

public class LottoBonus {
    private int number;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;

    public LottoBonus(Lotto lotto, int number){
        validate(lotto, number);
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public void validate(Lotto lotto, int number){
        if(lotto.getNumbers().contains(number)){
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 번호와 중복되는 당첨 번호가 있습니다.");
        } else if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 번호는 범위에 해당하지 않습니다.");
        }
    }
}
