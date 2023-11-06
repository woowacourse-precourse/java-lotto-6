package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinner;
import lotto.service.DrawService;
import lotto.view.Input;
import lotto.view.Output;

public class DrawController {
	private final DrawService drawService;

	public DrawController(DrawService drawService) {
		this.drawService = drawService;
	}

	public void drawLotto(List<Lotto> puchaseLottoList) {
		LottoWinner lottoWinner = new LottoWinner();
		Input.winningNumbers().stream()
			.map(LottoNumber::from)
			.forEach(lottoWinner::addNormal);
		lottoWinner.addBonus(LottoNumber.from(Input.bonusNumber()));
		Output.winningResult(drawService.drawLotto(lottoWinner, puchaseLottoList));
	}
}
