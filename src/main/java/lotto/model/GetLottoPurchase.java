package lotto.model;


import lotto.view.ExceptionMessage;

public class GetLottoPurchase {
    private final int getCost;

    public int getGetCost() {
        return getCost;
    }

    public GetLottoPurchase(String inputCost){
        int cost;
        cost = validateNumber(inputCost);
        cost = validateCanPurchase(cost);
        this.getCost = cost;
    }

    public int validateNumber(String cost){
        try{
            return Integer.parseInt(cost);
        } catch (IllegalArgumentException e){
            ExceptionMessage.numberException();
            return 0;
        }
    }

    private int validateCanPurchase(int cost) {
        if (cost % 1000 != 0) {
            ExceptionMessage.wrongNumberException();
            return 0;
        }
        return cost;
    }
}

