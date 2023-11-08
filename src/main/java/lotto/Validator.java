package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static Integer purchaseAmountValidation(String purchaseAmountString) {
        Integer purchaseAmount;
        try {
            purchaseAmount = Integer.valueOf(purchaseAmountString);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] : 숫자만 입력해주시기 바랍니다.");
        }

        if (purchaseAmount % 1000 >= 1) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 입력해주시기 바랍니다.");
        }
        return purchaseAmount / 1000;
    }

    public static List<Integer> LuckyNumberValidation(String lotto) {
        String[] lottoNumbers = lotto.split(",");
        List<Integer> lottoNumberList = new ArrayList<>();
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] : ','로 구분하여 6개의 숫자를 입력해주십시오.");
        }
        for (int i = 0; i < 6; i++) {
            Integer number = NumberValidation(lottoNumbers, i);
            lottoNumberList.add(number);
        }

        return lottoNumberList;
    }

    public static Integer NumberValidation(String[] lottoNumbers, Integer i) {
        Integer number;
        try {
            number = Integer.valueOf(lottoNumbers[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자만 입력해주십시오.");
        }
        if (number < 0 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] : 숫자의 범위는 1 ~ 45 입니다.");
        }
        return number;
    }
}
