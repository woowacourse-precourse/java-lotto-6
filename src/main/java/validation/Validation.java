package validation;

public class Validation {
    public Integer validateMoney(Integer money){
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1000의 배수여야 합니다.");
        }
        return money/1000;
    }
}
