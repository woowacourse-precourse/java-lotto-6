package lotto.domain;

import lotto.domain.dto.output.LottosDto;

public class DrawMachine {
    private final lotto.domain.Lotto winningNumbers;
    private final LottoNumber bonusNumber;
    private final LottosDto lottosDto;

    public DrawMachine(lotto.domain.Lotto winningNumbers, LottoNumber bonusNumber, LottosDto lottosDto) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottosDto = lottosDto;
    }

    public void draw() {

    }
}
