package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoRank;
import lotto.domain.RankResult;
import lotto.dto.output.RankResultDTO;
import lotto.dto.output.ResultDTO;
import lotto.view.console.OutputView;

public class ResultController {
    private final RankResult rankResult;

    private ResultController(RankResult rankResult) {
        this.rankResult = rankResult;
    }

    public static ResultController from(RankResult rankResult) {
        return new ResultController(rankResult);
    }

    public void showResults() {
        List<RankResultDTO> rankResultDTOs = createRankResultDTOs();
        ResultDTO resultDTO = ResultDTO.from(rankResultDTOs);
        OutputView.printRankResult(resultDTO);
    }

    private List<RankResultDTO> createRankResultDTOs() {
        return Arrays.stream(LottoRank.values())
                .filter(this::isInRank)
                .map(this::toRankResultDTO)
                .collect(Collectors.toList());
    }

    private boolean isInRank(LottoRank rank) {
        return rank != LottoRank.NONE;
    }

    private RankResultDTO toRankResultDTO(LottoRank rank) {
        int count = rankResult.getCount(rank);
        int reward = rank.getReward();
        int matchCount = rank.getMatchCount();
        boolean isBonusMatch = rank == LottoRank.SECOND;
        return RankResultDTO.of(count, reward, matchCount, isBonusMatch);
    }
}
