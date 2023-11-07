package lotto.dto.output;

import java.util.List;

public class ResultDTO {
    private final List<RankResultDTO> results;

    private ResultDTO(List<RankResultDTO> results) {
        this.results = results;
    }

    public static ResultDTO from(List<RankResultDTO> results) {
        return new ResultDTO(results);
    }

    public List<RankResultDTO> getResults() {
        return this.results;
    }
}
