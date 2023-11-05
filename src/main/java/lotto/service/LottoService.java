package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.controller.dto.ResultResponseDto;
import lotto.domain.Lotto;
import lotto.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoService {

    LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> generateLotto(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> lottoGenerator.lottoGenerate())
                .collect(Collectors.toList());
    }

    public List<ResultResponseDto> convertToDto(List<LottoResult> lottoResults) {
        List<ResultResponseDto> dtos = new ArrayList<>();
        List<LottoResult> results = List.of(LottoResult.FIFTH, LottoResult.FOURTH,
                LottoResult.THIRD, LottoResult.SECOND, LottoResult.FIRST);

        for (LottoResult result : results) {
            int count = (int) lottoResults.stream().filter(temp -> temp == result)
                    .count();
            ResultResponseDto dto = result.toResponseDto(count);
            dtos.add(dto);
        }

        return dtos;
    }

    public List<LottoResult> returnLottoResult(Lotto userLotto, Lottos generatedLottos,
            int bonusNumber) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (int i = 0; i < generatedLottos.size(); i++) {
            Lotto tempLotto = generatedLottos.get(i);
            int count = tempLotto.countContainsNumber(userLotto);
            boolean hasBonus = isHasBonus(bonusNumber, count, tempLotto);
            lottoResults.add(LottoResult.getResult(count, hasBonus));
        }
        return lottoResults;
    }

    private boolean isHasBonus(int bonusNumber, int count, Lotto tempLotto) {
        boolean hasBonus = false;
        if (count == 5) {
            hasBonus = tempLotto.isContain(bonusNumber);
        }
        return hasBonus;
    }
}
