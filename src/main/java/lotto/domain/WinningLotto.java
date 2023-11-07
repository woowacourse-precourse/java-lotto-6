package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    // 입력된 winningNumbers와 bonusNumber가 올바른지 검증 필요
    public WinningLotto(LottoTicket winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 당첨 결과 계산 로직 작성 필요
    public LottoResult compare(List<LottoTicket> tickets) {
    }
}
