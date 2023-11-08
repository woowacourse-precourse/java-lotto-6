package lotto.domain.message;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumbersDTO;

public class Messenger {

    private final String LOTTERIES_NUMBERS_FORMAT = "[%s]";
    private final String LOTTERIES_NUMBERS_DELIMITER = ", ";
    private final String NEXT_LINE = "\n";

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

}
