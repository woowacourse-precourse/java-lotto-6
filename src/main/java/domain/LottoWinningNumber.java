package domain;

import util.InputUtil;
import util.MessageUtil;
import util.ValidationUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {
    private final InputUtil inputUtil = new InputUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private List<Integer> winningLottoNumbers;

    public LottoWinningNumber getLottoWinningNumInfo() {
        this.winningLottoNumbers = getLottoWinningNumber();
        return this;
    }
    public List<Integer> getLottoWinningNum(){
        return winningLottoNumbers;
    }
    private List<Integer> getLottoWinningNumber(){
        messageUtil.printWinningNum();
        String winningNumber = inputUtil.userInput();
        String[] validWinningNumber = validationUtil.validWinningNumber(winningNumber);
        return Arrays.stream(validWinningNumber).map(Integer::parseInt).collect(Collectors.toList());
    }
}
