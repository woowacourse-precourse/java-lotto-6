package lotto.controller;

import static lotto.view.View.requestBonusNumber;
import static lotto.view.View.requestWinningNumbers;

import lotto.domain.Lottos;
import lotto.dto.DrawnNumbersDto;
import lotto.view.View;

public class LottoController {
    public void run() {
        issue();
        draw();
    }

    private void issue() {
        int cost = Integer.parseInt(View.requestCost());
        Lottos lottos = Lottos.from(getCountFrom(cost));
        View.printLottos(lottos);
    }

    private void draw() {
        DrawnNumbersDto dto = DrawnNumbersDto.of(requestWinningNumbers(), requestBonusNumber());
    }

    private int getCountFrom(int cost) {
        return cost / 1000;
    }
}
