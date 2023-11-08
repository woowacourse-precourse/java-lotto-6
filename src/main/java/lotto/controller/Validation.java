package lotto.controller;

import java.util.List;

public class Validation {

    public void purchaseAmount(String input) {
        if(!input.matches("^[\\d]*$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력해야 합니다.");
        } else if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }
    }

    public void winNumber(List<String> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }

        try {
            for (String num : numbers) {
                Integer.parseInt(num);
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력해야 합니다.");
        }


    }
}
