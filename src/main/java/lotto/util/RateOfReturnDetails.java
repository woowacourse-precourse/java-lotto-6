package lotto.util;

public enum RateOfReturnDetails {
    ROUND_STANDARD(10.0);

    private final Double detail;

    RateOfReturnDetails(Double detail) {
        this.detail = detail;
    }

    public Double getDetail() {
        return detail;
    }
}
