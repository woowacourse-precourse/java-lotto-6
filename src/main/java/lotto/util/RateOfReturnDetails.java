package lotto.util;

/**
 * 수익률에 관한 정보를 저장한다.
 */
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
