package lotto.dto;

import java.util.List;
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
                .map((entry -> ResultDto.of(entry.getKey(), entry.getValue())))
                .toList());
    }

    public List<ResultDto> getResultsDto() {
        return resultsDto;
    }

}
