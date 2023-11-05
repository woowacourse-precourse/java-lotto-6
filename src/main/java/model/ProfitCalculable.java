package model;

import java.util.EnumMap;

public interface ProfitCalculable {
    public abstract String calculateRateOfProfit(String money, int profit);
    public abstract int calculateProfit(EnumMap<Rank,Integer> result);
}
