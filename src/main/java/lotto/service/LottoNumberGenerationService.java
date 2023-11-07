package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.port.LottoNumbersProvider;

public class LottoNumberGenerationService {
    private final LottoNumbersProvider lottoNumbersProvider;

    public LottoNumberGenerationService(LottoNumbersProvider lottoNumbersProvider) {
        this.lottoNumbersProvider = lottoNumbersProvider;
    }

    public List<List<Integer>> generateLottoNumbers(int lottoTicketsCount) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();

        System.out.println(lottoTicketsCount + "개를 구매했습니다.");

        for (int i = 0; i < lottoTicketsCount; i++) {
            List<Integer> lottoNumbers = lottoNumbersProvider.provideLottoNumbers();
            Collections.sort(lottoNumbers);
            allLottoNumbers.add(lottoNumbers);
            System.out.println(lottoNumbers);
        }
        return allLottoNumbers;
    }
}
