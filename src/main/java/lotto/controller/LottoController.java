package lotto.controller;

import static lotto.utils.LottoUtils.divisionLottoPrice;
import static lotto.utils.LottoUtils.generateRandomNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutView;

public class LottoController {

    private final InputView inputView;
    private final OutView outView;

    public LottoController() {
        this.inputView = new InputView();
        this.outView = new OutView();
    }

    public void run() {
        int priceLotto = inputView.parseInputFromUserInteger();
        int divisionLottoPrice = divisionLottoPrice(priceLotto);
        List<LottoDto> generateLottoNumbersDto = createLottoGenerate(divisionLottoPrice);
    }

    public List<LottoDto> createLottoGenerate(int divisionLottoPrice) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        System.out.println();
        outView.lottoPriceView(divisionLottoPrice);
        for (int i = 0; i < divisionLottoPrice; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottoDtos.add(new LottoDto(lotto.getLotto()));
            outView.randomLottoOutView(lotto.getLotto());
        }
        return lottoDtos;
    }
}
