package lotto.model.dto;

import java.math.BigDecimal;
import lotto.model.calculate.MarginRate;

public class MarginRateDto {
    private final BigDecimal wholePart;
    private final BigDecimal fractionalPart;

    public MarginRateDto(MarginRate marginRate) {
        this.wholePart = marginRate.seperateWholePart();
        this.fractionalPart = marginRate.seperatefractionalPart();
    }

    public BigDecimal getWholePart() {
        return wholePart;
    }

    public BigDecimal getFractionalPart() {
        return fractionalPart;
    }
}
