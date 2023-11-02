package lotto.dto;

import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Result;

public class ResultsDto {

    private final List<ResultDto> resultsDto;

    private ResultsDto(List<ResultDto> resultsDto) {
        this.resultsDto = resultsDto;
    }

    public static ResultsDto of(Result result) {
        return new ResultsDto(result.getRankCount()
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Rank.NONE)
                .map((entry -> ResultDto.of(entry.getKey(), entry.getValue())))
                .sorted()
                .toList());
    }

    public List<ResultDto> getResultsDto() {
        return resultsDto;
    }

}
