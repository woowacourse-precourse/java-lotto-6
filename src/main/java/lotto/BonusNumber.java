package lotto;

import java.util.List;

public class BonusNumber {

    public String number;
    public List<Integer> lottoNumbers;

    public BonusNumber(String number, List<Integer> lottoNumbers) {
        validate(number, lottoNumbers);
        validateNumberRange(Integer.parseInt(number));
        this.number = number;
        this.lottoNumbers = lottoNumbers;
    }

    public void validate(String number, List<Integer> lottoNumbers){
        if (lottoNumbers.contains(Integer.parseInt(number))){
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복입니다.");
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자가 아닙니다.");
        }
    }
}
