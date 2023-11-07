package lotto.model;


import lotto.view.InputView;
public class CalculateNumberOfLotto {

    private static final int LOTTO_PRICE = 1000;
    private final int numberOfLotto;

    private CalculateNumberOfLotto(int totalCost){
        this.numberOfLotto = calculateLotto(totalCost);
    }
    public int calculateLotto(int totalCost){
        return totalCost / LOTTO_PRICE;
    }

    public static CalculateNumberOfLotto InputCost(int totalCost){
        return new CalculateNumberOfLotto(totalCost);
    }

    public int getCalculateNumberOfLotto(){
        return numberOfLotto;
    }



}
