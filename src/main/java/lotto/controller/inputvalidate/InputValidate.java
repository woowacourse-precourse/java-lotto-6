package lotto.controller.inputvalidate;

import lotto.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class InputValidate{
    public int validateIsDigit(String inputValue){
        try{
            return Integer.parseInt(inputValue);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호나 금액의 경우 숫자만 입력 해야 합니다.");
        }
    }
    public int isLottoNumber(int value){
        if(value < 1 || value > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        return value;
    }
}
