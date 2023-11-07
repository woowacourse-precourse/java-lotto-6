package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.UserLottos;
import lotto.service.CalculateLottoPrizeService;
import lotto.service.CalculateProiftService;
import lotto.service.GenerateLottosService;
import lotto.service.InputWinningNumberService;
import lotto.view.InputBonusView;
import lotto.view.InputPriceView;
import lotto.view.InputWinningNumberView;

public class GameController {
    GenerateLottosService generateLottosService = new GenerateLottosService();
    InputWinningNumberService inputWinningNumberService = new InputWinningNumberService();
    CalculateLottoPrizeService calculateLottoPrizeService = new CalculateLottoPrizeService();
    CalculateProiftService calculateProiftService = new CalculateProiftService();
    InputPriceView inputPriceView = new InputPriceView();
    InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
    InputBonusView inputBonusView = new InputBonusView();

    public void start() {
        UserLottos userLottos = generateLottosService.setLottos(getPrice());
        Lotto lotto = inputWinningNumberService.setWinningNum(getWinningNum());
        inputWinningNumberService.setBonusNum(lotto, getBonus());
        calculateLottoPrizeService.calculatePrize(userLottos, lotto);
        calculateProiftService.printProfit(userLottos.getWinningPrice(), userLottos.getBuyingPrice());
    }

    public String getPrice() {
        return inputPriceView.inputPrice();
    }

    public String getWinningNum() {
        return inputWinningNumberView.inputWinningNum();
    }

    public String getBonus() {
        return inputBonusView.inputBonus();
    }
}
