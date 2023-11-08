package lotto.domain.message;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.WinStateInformationDTO;

import static lotto.domain.message.MessageConstant.*;

public class Messenger {

    public String getInputPurchaseCashAmountMessage() {
        return INPUT_PURCHASE_CASH_AMOUNT;
    }

    public String getPurchasedLotteriesCountMessage(int count) {
        return String.format(PURCHASED_LOTTERIES_FORMAT, count);
    }

    public String getLotteriesNumbersMessage(List<LottoNumbersDTO> lottoNumbersDTOs) {
        return lottoNumbersDTOs.stream()
                .map(this::getLottoNumbersMessage)
                .collect(Collectors.joining(NEXT_LINE));
    }

    private String getLottoNumbersMessage(LottoNumbersDTO lottoNumbersDTO) {
        String lottoNumbers = lottoNumbersDTO.numbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTERIES_NUMBERS_DELIMITER));

        return String.format(LOTTERIES_NUMBERS_FORMAT, lottoNumbers);
    }

    public String getInputWinningNumbersMessage() {
        return INPUT_WINNING_NUMBERS;
    }

    public String getInputBonusNumberMessage() {
        return INPUT_BONUS_NUMBER;
    }

    public String getWinningStatisticStartMessage() {
        return WINNING_STATISTICS_START;
    }

    public String getWinningStatisticsInformationMessage(List<WinStateInformationDTO> winStateInformationDTOs) {
        return winStateInformationDTOs.stream()
                .map(this::getWinningStatisticInformationMessage)
                .collect(Collectors.joining(NEXT_LINE));
    }

    private String getWinningStatisticInformationMessage(WinStateInformationDTO winStateInformationDTO) {
        return String.format(
                WINNING_STATISTIC_INFORMATION_FORMAT,
                winStateInformationDTO.description(),
                PRIZE_FORMAT.format(winStateInformationDTO.prize()),
                winStateInformationDTO.winningCount()
        );
    }

    public String getYieldMessage(double yield) {
        return String.format(YIELD_MESSAGE_FORMAT, YIELD_FORMAT.format(yield));
    }

}
