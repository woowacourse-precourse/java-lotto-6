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
		LottoWinner lottoWinner = getLottoWinner();
		addBonusNumber(lottoWinner);
		Output.winningResult(drawService.drawLotto(lottoWinner, puchaseLottoList));
	}

	private static void addBonusNumber(LottoWinner lottoWinner) {
		try {
			int bonusNumber = Input.bonusNumber();
			lottoWinner.addBonus(LottoNumber.from(bonusNumber));
			return;
		} catch (IllegalArgumentException e) {
			Output.exception(e);
		}
		addBonusNumber(lottoWinner);
	}

	private static LottoWinner getLottoWinner() {
		try {
			LottoWinner lottoWinner = new LottoWinner();
			Input.winningNumbers().stream()
				.map(LottoNumber::from)
				.forEach(lottoWinner::addNormal);
			return lottoWinner;
		} catch (IllegalArgumentException e) {
			Output.exception(e);
		}
		return getLottoWinner();
	}
}
