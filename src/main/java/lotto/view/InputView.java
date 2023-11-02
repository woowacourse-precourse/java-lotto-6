package lotto.view;

import lotto.validation.Validator;


import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputNumber = readLine();
        try{
            Validator.validateOnlyNumber(inputNumber);
            Validator.validateInt(inputNumber);
            Validator.validateThousandMultiple(Integer.parseInt(inputNumber));
            Validator.validateMoreThan1000(Integer.parseInt(inputNumber));
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 1000이상의 정수형으로 입력해주세요.");
            return inputPrice();
        }
        return Integer.parseInt(inputNumber);
    }


}
