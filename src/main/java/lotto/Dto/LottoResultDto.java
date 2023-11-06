package lotto.Dto;

import java.util.List;

public class LottoResultDto {
    List<Integer> lottoResult;
    int profit;

    public LottoResultDto(List<Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }
}
