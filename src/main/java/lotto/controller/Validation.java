package lotto.controller;

import java.util.List;
import lotto.Util;

public class Validation {

    public void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public void isNumber(List<String> input) {
        try {
            for(String num : input) {
                Integer.parseInt(num);
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public void lottoNumberCount(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void duplicateNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    public void rangeOfLottoNumber(List<Integer> numbers) {
        for(int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
            }
        }
    }

    public void purchaseAmount(String input) {
        isNumber(input);
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }
    }

    public void winNumber(List<String> numbers) {
        Util util = new Util();
        List<Integer> winNumber = util.stringListToIntegerList(numbers);
        lottoNumberCount(winNumber);
        duplicateNumber(winNumber);
        rangeOfLottoNumber(winNumber);
    }
}
