package lotto.controller;

public class Validation {

    public void purchaseAmount(String input) {
        if(!input.matches("^[\\d]*$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력해야 합니다.");
        } else if(Long.parseLong(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }
    }
}
