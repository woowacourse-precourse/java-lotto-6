package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.controller.dto.ResultResponseDto;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.UserLotto;
import lotto.util.LottoGenerator;

public class LottoService {

    LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> generateLotto(int count) {
        return IntStream.range(0, count).mapToObj(i -> lottoGenerator.lottoGenerate())
                .collect(Collectors.toList());
    }

    public List<ResultResponseDto> convertToDto(List<LottoResult> lottoResults) {
        return Stream.of(LottoResult.FIFTH, LottoResult.FOURTH, LottoResult.THIRD,
                LottoResult.SECOND, LottoResult.FIRST).map(resultRank -> {
            int count = getLottoResultCount(lottoResults, resultRank);
            return resultRank.toResponseDto(count);
        }).collect(Collectors.toList());
    }

    private int getLottoResultCount(List<LottoResult> lottoResults, LottoResult result) {
        return (int) lottoResults.stream().filter(temp -> temp == result).count();
    }

    public List<LottoResult> returnLottoResult(UserLotto userLotto, Lottos generatedLottos) {
        Lotto lotto = userLotto.getLotto();
        int bonusNumber = userLotto.getBonusNumber();
        List<LottoResult> lottoResults = new ArrayList<>();
        for (int i = 0; i < generatedLottos.size(); i++) {
            Lotto tempLotto = generatedLottos.get(i);
            int count = tempLotto.countContainsNumber(lotto);
            boolean hasBonus = isHasBonus(bonusNumber, count, tempLotto);
            lottoResults.add(LottoResult.getResult(count, hasBonus));
        }
        return lottoResults;
    }

    private boolean isHasBonus(int bonusNumber, int count, Lotto lotto) {
        boolean hasBonus = false;
        if (count == 5) {
            hasBonus = lotto.isContain(bonusNumber);
        }
        return hasBonus;
    }
}
