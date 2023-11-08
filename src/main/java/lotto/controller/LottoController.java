package lotto.controller;

import static lotto.constants.LottoConstants.BONUS;
import static lotto.constants.LottoConstants.WINNING;
import static lotto.utils.LottoUtils.divisionLottoPrice;
import static lotto.utils.LottoUtils.generateRandomNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutView;

public class LottoController {

    private final InputView inputView;
    private final OutView outView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outView = new OutView();
        this.lottoService = new LottoService();
    }

    public void run() {
        int priceLotto = inputView.parseInputFromUserInteger();
        int divisionLottoPrice = divisionLottoPrice(priceLotto);
        List<LottoDto> generateLottoNumbers = createLottoGenerate(divisionLottoPrice);
        outView.lottoCommonNumberView(WINNING);
        List<Integer> lottoWinnerNumbers = lottoService.createWinningNumbers(inputView.commonInput());
        outView.lottoCommonNumberView(BONUS);
        int bonusNumber = lottoService.createBonusNumber(lottoWinnerNumbers, inputView.commonInput());
        System.out.println();
        List<Map<Integer, Integer>> lottoFindWinner = lottoService.findWinners(lottoWinnerNumbers, bonusNumber,
                generateLottoNumbers);
        outView.winnersMsg(lottoFindWinner, priceLotto);
    }


    public List<LottoDto> createLottoGenerate(int divisionLottoPrice) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        System.out.println();
        outView.lottoPriceView(divisionLottoPrice);
        for (int i = 0; i < divisionLottoPrice; i++) {
            List<Integer> generatorRandomNumber = new ArrayList<>(generateRandomNumbers());
            Collections.sort(generatorRandomNumber);
            Lotto lotto = new Lotto(generatorRandomNumber);
            lottoDtos.add(new LottoDto(lotto.getLotto(), lotto));
            outView.randomLottoOutView(lotto.getLotto());
        }
        return lottoDtos;
    }
}
