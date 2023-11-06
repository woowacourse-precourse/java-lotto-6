package lotto.domain;

import java.util.List;

public record LottoAnswer(
        List<Integer> lottoNumbers,
        int lottoBonusNumber
) {
}
