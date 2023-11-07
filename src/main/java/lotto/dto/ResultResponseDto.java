package lotto.dto;

import java.util.Map;
import lotto.domain.Ranking;
import net.bytebuddy.asm.Advice.Return;

public class ResultResponseDto {
    private final Map<Ranking, Integer> result;

    public ResultResponseDto(Map<Ranking, Integer> result) {
        this.result = result;
    }

    public int getCountByRanking(Ranking ranking) {
        return result.getOrDefault(ranking, 0);
    }
}
