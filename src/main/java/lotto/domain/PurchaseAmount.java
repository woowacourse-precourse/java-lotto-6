package lotto.domain;

import static lotto.exception.ErrorMessage.IS_NOT_MULTIPLE_OF_THOUSAND;

import lotto.exception.LottoException;

public class PurchaseAmount {
    private final int purchaseAmount;

    private PurchaseAmount(final int purchaseAmount){

        MultipleOfThousand(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount creat (final int purchaseAmount){
        return new PurchaseAmount(purchaseAmount);
    }

    private static void MultipleOfThousand(int purchaseAmount){
        if(isMultipleOfThousand(purchaseAmount)){
            throw LottoException.of(IS_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    public static boolean isMultipleOfThousand(int purchaseAmount){
        return (purchaseAmount/1000) != 0;
    }
}
