package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.StringConstants;
import lotto.domain.Lotto;
import lotto.port.LottoNumbersProvider;
import lotto.port.OutputPort;

public class LottoNumberGenerationService {

    private final LottoNumbersProvider lottoNumbersProvider;
    private final OutputPort outputPort;

    public LottoNumberGenerationService(LottoNumbersProvider lottoNumbersProvider,OutputPort outputPort) {
        this.lottoNumbersProvider = lottoNumbersProvider;
        this.outputPort =outputPort;
    }

    public List<Lotto> generateLottoNumbers(int lottoTicketsCount) {
        List<Lotto> allLottoNumbers = new ArrayList<>();

        outputPort.printLine(lottoTicketsCount + StringConstants.PURCHASED_COUNT_MESSAGE);

        for (int i = 0; i < lottoTicketsCount; i++) {
            Lotto lottoNumbers = lottoNumbersProvider.provideLottoNumbers();
            allLottoNumbers.add(lottoNumbers);
            outputPort.printLine(lottoNumbers.getNumbers());
        }
        return allLottoNumbers;
    }
}
