package lotto.domain.message;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.WinStateInformationDTO;

public class Messenger {

    private final String PURCHASED_LOTTERIES_FORMAT = "\n%d개를 구매했습니다.";

    private final String LOTTERIES_NUMBERS_FORMAT = "[%s]";
    private final String LOTTERIES_NUMBERS_DELIMITER = ", ";
    private final String NEXT_LINE = "\n";

    private final String WINNING_STATISTIC_INFORMATION_FORMAT = "%s (%s원) - %d개";
    private final DecimalFormat PRIZE_FORMAT = new DecimalFormat("###,###,###");

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

    public String getPurchasedLotteriesCount(int count) {
        return String.format(PURCHASED_LOTTERIES_FORMAT, count);
    }

    public String getWinningStatisticInformation(WinStateInformationDTO winStateInformationDTO) {
        return String.format(
                WINNING_STATISTIC_INFORMATION_FORMAT,
                winStateInformationDTO.description(),
                PRIZE_FORMAT.format(
                        winStateInformationDTO.prize()
                ),
                winStateInformationDTO.winningCount()
        );
    }

}
