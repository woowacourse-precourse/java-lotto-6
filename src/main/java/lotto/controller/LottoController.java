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
        List<Integer> lottoWinnerNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(lottoWinnerNumbers);
        List<Map<Integer, Integer>> lottoFindWinner = findWinners(lottoWinnerNumbers, bonusNumber,
                generateLottoNumbers);
        outView.winnersMsg(lottoFindWinner, priceLotto);
    }

    private List<LottoDto> createLottoGenerate(int divisionLottoPrice) {
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

    private List<Integer> getWinningNumbers() {
        outView.lottoCommonNumberView(WINNING);
        return lottoService.createWinningNumbers(inputView.commonInput());
    }

    private int getBonusNumber(List<Integer> lottoWinnerNumbers) {
        outView.lottoCommonNumberView(BONUS);
        return lottoService.createBonusNumber(lottoWinnerNumbers, inputView.commonInput());
    }

    private List<Map<Integer, Integer>> findWinners(List<Integer> lottoWinnerNumbers, int bonusNumber,
            List<LottoDto> generateLottoNumbers) {
        return lottoService.findWinners(lottoWinnerNumbers, bonusNumber, generateLottoNumbers);
    }
}
