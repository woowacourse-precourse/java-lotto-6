package lotto.domain;


import java.util.List;
import lotto.common.Constant;
import lotto.common.ErrorMessage;
import lotto.domain.dto.LottoNumberCompareResult;

public class LottoStorage {

    private final WinningLotto winningLotto;
    private final Integer totalPrice;


    public LottoStorage(final WinningLotto winningLotto, final Integer totalPrice) {
        validate(totalPrice);

        this.winningLotto = winningLotto;
        this.totalPrice = totalPrice;
    }

    public LottoNumberCompareResult compareToWinningLottoNumber(List<Integer> automaticLottoNumber) {
        int matchingCount = 0;
        boolean bonusIncluded = false;

        matchingCount = (int) automaticLottoNumber.stream().filter(winningLotto::isWinningNumber).count();

        if(automaticLottoNumber.stream().anyMatch(number -> number.equals(winningLotto.getBonusNumber()))) {
            matchingCount++;
            bonusIncluded = true;
        }

        return LottoNumberCompareResult.of(matchingCount, bonusIncluded);
    }

    public Integer getTicketCount() {
        return this.totalPrice / Constant.LOTTO_TICKET_PRICE;
    }

    private void validate(final Integer totalPrice) {
        if (totalPrice % Constant.LOTTO_TICKET_PRICE > 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PURCHASE_AMOUNT_INVALID_ERROR.getMessage());
        }
    }
}
