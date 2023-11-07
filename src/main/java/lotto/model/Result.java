package lotto.model;

import java.util.List;
import lotto.dto.LottoDto;

public class Result {
    private Integer firstPrize = 0;
    private Integer secondPrize = 0;
    private Integer thirdPrize = 0;
    private Integer fourthPrize = 0;
    private Integer fifthPrize = 0;

    public static Result calculate(List<LottoDto> lottoDtos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        return null;
    }
}
