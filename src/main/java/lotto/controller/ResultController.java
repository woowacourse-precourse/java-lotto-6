package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Rank;
import lotto.domain.RankResult;
import lotto.dto.output.RankResultDTO;
import lotto.dto.output.ResultDTO;
import lotto.view.console.OutputView;

public class ResultController {
    private final RankResult rankResult;

    public ResultController(RankResult rankResult) {
        this.rankResult = rankResult;
    }

    public void showResults() {
        ResultDTO resultDTO = createResultDTO();
        OutputView.printRankResult(resultDTO);
    }

    private ResultDTO createResultDTO() {
        List<RankResultDTO> rankResultDTOs = createRankResultDTOs();
        return ResultDTO.from(rankResultDTOs);
    }

    private List<RankResultDTO> createRankResultDTOs() {
        return Arrays.stream(Rank.values())
                .filter(this::isRank)
                .map(this::convertToRankResultDTO)
                .collect(Collectors.toList());
    }

    private boolean isRank(Rank rank) {
        return rank != Rank.NONE;
    }

    private RankResultDTO convertToRankResultDTO(Rank rank) {
        int count = rankResult.getCount(rank);
        int reward = rank.getReward();
        int matchCount = rank.getMatchCount();
        return RankResultDTO.of(count, reward, matchCount);
    }
}
