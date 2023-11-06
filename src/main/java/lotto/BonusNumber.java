package lotto;

import java.util.List;

public class BonusNumber {

    public String number;
    public List<Integer> lottoNumbers;

    public BonusNumber(String number, List<Integer> lottoNumbers) {
        validate(number, lottoNumbers);
        this.number = number;
        this.lottoNumbers = lottoNumbers;
    }

    public void validate(String number, List<Integer> lottoNumbers){
        if (lottoNumbers.contains(Integer.parseInt(number))){
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복입니다.");
        }
    }
}
