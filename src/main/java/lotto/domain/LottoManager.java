package lotto.domain;

import lotto.errors.ErrorMessage;
import lotto.output.OutputView;

public class LottoManager {

    private static LottoManager lottoManager;

    private int numberOfLottos;

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

    public void setNumberOfLottos(String cost) {
        int integerCost = parseIntCost(cost);
        isSmallerthanZero(integerCost);
        calculateNumberOfLottos(integerCost);
        this.numberOfLottos = integerCost/1000;
    }

    private int parseIntCost(String cost){
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
}
