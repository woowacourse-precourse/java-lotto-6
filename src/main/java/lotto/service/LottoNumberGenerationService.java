package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.StringConstants;
import lotto.port.LottoNumbersProvider;
import lotto.port.OutputPort;

public class LottoNumberGenerationService {

    private final LottoNumbersProvider lottoNumbersProvider;
    private final OutputPort outputPort;

    public LottoNumberGenerationService(LottoNumbersProvider lottoNumbersProvider,OutputPort outputPort) {
        this.lottoNumbersProvider = lottoNumbersProvider;
        this.outputPort =outputPort;
    }

    public List<List<Integer>> generateLottoNumbers(int lottoTicketsCount) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();

        outputPort.printLine(lottoTicketsCount + StringConstants.PURCHASED_COUNT_MESSAGE);

        for (int i = 0; i < lottoTicketsCount; i++) {
            List<Integer> lottoNumbers = lottoNumbersProvider.provideLottoNumbers();
            allLottoNumbers.add(lottoNumbers);
            outputPort.printLine(lottoNumbers);
        }
        return allLottoNumbers;
    }
}
