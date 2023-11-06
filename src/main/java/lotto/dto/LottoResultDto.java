package lotto.dto;

import lotto.model.LottoGrade;

public record LottoResultDto(
        LottoGrade grade,
        String correct,
        int amount,
        int winningCount
) {
}
