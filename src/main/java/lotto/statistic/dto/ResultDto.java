package lotto.statistic.dto;

import java.util.List;

public class ResultDto {

    private List<Integer> ranks;
    private double revenue;

    public ResultDto(List<Integer> ranks, double revenue) {
        this.ranks = ranks;
        this.revenue = revenue;
    }

    public List<Integer> getRanks() {
        return ranks;
    }

    public void setRanks(List<Integer> ranks) {
        this.ranks = ranks;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
