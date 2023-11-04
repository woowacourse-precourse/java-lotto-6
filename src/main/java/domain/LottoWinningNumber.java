package domain;

import util.CreateRandomNumberUtil;
import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;

import java.util.List;

public class LottoWinningNumber {
    private final InputUtil inputUtil = new InputUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();

//    private List<Lotto> lottos;
    public LottoWinningNumber getLottoWinningNumInfo(){
        messageUtil.printWinningNum();
        String winningNumber = inputUtil.userInput();

//        String[] winningEachNumber = winningNumber.split(",\\s*");
        return this;
    }
}
