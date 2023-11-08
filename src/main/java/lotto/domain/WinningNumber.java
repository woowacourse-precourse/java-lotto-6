package lotto.domain;

import lotto.util.BonusValidator;
import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.NumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final InputUtil inputUtil = new InputUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final NumberValidator numberValidator = new NumberValidator();
    private final BonusValidator bonusValidator = new BonusValidator();
    private List<Integer> winningNums;
    private Integer bonusNum;

    public WinningNumber getWinningNumberInfo() {
        this.winningNums = getWinningNumbers();
        this.bonusNum = getBonusNumber();

        return this;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }

    private List<Integer> getWinningNumbers() {
        messageUtil.printWinningInput();
        String winningNums = inputUtil.getUserInput();
        String[] winningAmount = numberValidator.validateWinningNumber(winningNums);

        return Arrays.stream(winningAmount)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private int getBonusNumber() {
        messageUtil.printBonusInput();
        int bonusNum = Integer.parseInt(inputUtil.getUserInput());
        bonusValidator.validateBonusNumber(bonusNum);

        return bonusNum;
    }
}
