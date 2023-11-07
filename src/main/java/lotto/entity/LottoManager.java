package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.property.ErrorProperty.LOTTO_RESULT_GENERATE_ERROR;

public class LottoManager {
    private static Map<LottoResult, Integer> resultEnumMap = new EnumMap<>(LottoResult.class);

    public LottoManager() {
        for (LottoResult result : LottoResult.values()) {
            resultEnumMap.put(result, 0);
        }
    }

    public void purchasedLottosResult(Integer winningCount, Boolean hitBonus) {
        updateResultEnumMap(lottoResultGenerate(winningCount, hitBonus));
    }

    private void updateResultEnumMap(LottoResult lottoResult) {
        if (resultEnumMap.containsKey(lottoResult)) {
            resultEnumMap.put(lottoResult, resultEnumMap.get(lottoResult) + 1);
        }
    }

    private LottoResult lottoResultGenerate(Integer winningCount, Boolean hitBonus) {
        return Stream.of(LottoResult.values())
                .filter(result -> {
                    if (winningCount.equals(5) && hitBonus) return result == LottoResult.FIVE_MATCH_WITH_BONUS;
                    return result.getCount().equals(winningCount);
                })
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(LOTTO_RESULT_GENERATE_ERROR.toString()));
    }

    public Map<LottoResult, Integer> getResultEnumMap() {
        return (Map<LottoResult, Integer>) FiledMapper.getFieldValue(this, MethodProperty.RESULT_ENUM_MAP);
    }
}
