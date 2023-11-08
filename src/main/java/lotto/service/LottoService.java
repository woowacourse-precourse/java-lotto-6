package lotto.service;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final PriceAmount priceAmount;
    private final Lottos lottos;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;


    public LottoService(String price) {
        this.priceAmount = new PriceAmount(Integer.parseInt(price));
        this.lottos = LottoFactory.createLottos(priceAmount.getPurchaseNumber());
    }

    public LottosDTO purchase() {
        return LottosDTO.from(lottos);
    }

    public DrawResult draw() {
        DrawingMachine drawingMachine = new DrawingMachine(winningLotto, bonusNumber);
        return drawingMachine.compare(lottos);
    }

    private List<Integer> convertFrom(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public PriceDTO getPriceDTO() {
        return new PriceDTO(priceAmount);
    }

    public void setWinningLotto(String numbers) {
        this.winningLotto = new Lotto(convertFrom(numbers));
    }

    public void setBonusNumber(String number) {
        this.bonusNumber = new BonusNumber(Integer.parseInt(number));
    }
}
