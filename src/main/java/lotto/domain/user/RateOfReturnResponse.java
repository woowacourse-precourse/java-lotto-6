package lotto.domain.user;

import java.math.BigDecimal;
import lotto.global.enums.ViewMessage;

public class RateOfReturnResponse {

    private BigDecimal rateOfReturn;

    public static RateOfReturnResponse from(BigDecimal rateOfReturn){
        return new RateOfReturnResponse(rateOfReturn);
    }

    private RateOfReturnResponse(BigDecimal rateOfReturn){
        this.rateOfReturn = rateOfReturn;
    }

    @Override
    public String toString(){
        return this.rateOfReturn + ViewMessage.OUTPUT_RATE_OF_RETURN_END.getMessage();
    }

}
