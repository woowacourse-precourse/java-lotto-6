package Model;

import lotto.Rank;

public class MoneyCalculateModel {
    private long totalMoney;
    private Integer investMoney;
    private double niceMoneyPercentage;
    public MoneyCalculateModel(Integer investMoney,RankCalculateModel rankCalculateModel) {
        totalMoney=sumAll(rankCalculateModel.getFirstRank()*200000000,
                rankCalculateModel.getSecondRank()*30000000,
                rankCalculateModel.getThirdRank()*1500000,
                rankCalculateModel.getFourthRank()*50000,
                rankCalculateModel.getFifthRank()*5000);
        this.investMoney=investMoney;
        niceMoneyPercentage=calculateNiceMoney();
    }
    private long sumAll(Integer a, Integer b, Integer c, Integer d, Integer e){
        return a+b+c+d+e;
    }
    private double calculateNiceMoney(){
        return ((double)totalMoney/(double)investMoney)*100;
    }
    public double getNiceMoneyPercentage(){
        return niceMoneyPercentage;
    }
    public void printNiceMoneyPercentage(){
        System.out.printf("총 수익률은 %.1f%%입니다.\n",getNiceMoneyPercentage());
    }



}
