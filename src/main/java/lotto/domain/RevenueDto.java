package lotto.domain;

public class RevenueDto {

    private double userRateOfRevenue;

    private RevenueDto(double rateOfRevenue) {
        this.userRateOfRevenue = rateOfRevenue;
    }

    public static RevenueDto from(double rateOfRevenue) {
        return new RevenueDto(rateOfRevenue);
    }

    public double getUserRateOfRevenue() {
        return userRateOfRevenue;
    }
}
