package lotto.dto;

import lotto.model.LottoResult;

public class ResultDto {
    private final String stat;

    private ResultDto(String stat) {
        this.stat = stat;
    }

    public static ResultDto from(LottoResult result) {
        return new ResultDto(result.toString());
    }

    @Override
    public String toString() {
        return stat;
    }
}
