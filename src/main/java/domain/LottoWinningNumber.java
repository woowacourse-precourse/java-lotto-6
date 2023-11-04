package domain;

import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;

import java.util.List;

public class LottoWinningNumber {
    private final InputUtil inputUtil = new InputUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();

    public LottoWinningNumber getLottoWinningNumInfo(){
        messageUtil.printWinningNum();
        String winningNumber = inputUtil.userInput();
        String[] validWinningNumber = validationUtil.validWinningNumber(winningNumber);
//        for (String number : winningNumbers) {
//            System.out.print(number + " "); // 각 숫자와 공백을 함께 출력
//        }
//        System.out.println();
        return this;
    }
}
