package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.errors.ErrorMessage;
import lotto.output.OutputView;

public class LottoManager {

    private static LottoManager lottoManager;

    private int numberOfLottos;

    private Integer bonusNumber;

    private LottoManager() {}

    public static LottoManager getInstance() {
        if (lottoManager==null) {
            lottoManager = new LottoManager();
        }
        return lottoManager;
    }

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setNumberOfLottos(String cost) {
        int integerCost = parseInt(cost);
        isSmallerthanZero(integerCost);
        calculateNumberOfLottos(integerCost);
        this.numberOfLottos = integerCost/1000;
    }

    public List<Integer> setLuckyNumbers(String luckyNumber) {
        return Arrays.stream(luckyNumber.trim().split("\\s*,\\s*"))
                .map(this::parseInt)
                .toList();
    }

    private int parseInt(String cost){
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
        }
    }

    private void isSmallerthanZero(int cost){
        if (cost<=0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SMALLER_THAN_ZERO.getMessage());
        }
    }

    private void calculateNumberOfLottos(int cost){
        if (cost%1000!=0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_COST.getMessage());
        }
    }

    public boolean checkNumberOfLottos() {
        return this.numberOfLottos>0;
    }

    public String printOutNumberOfLottos() {
        return this.numberOfLottos + OutputView.NUMBER_OF_LOTTOS.getMessage();
    }

    public int setBonusNumber(String input) {
        int bonusNumber = parseInt(input);
        validateRangeOfNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
        return this.bonusNumber;
    }

    private void validateRangeOfNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }
}
