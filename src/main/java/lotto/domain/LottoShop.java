package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private final NumberGenerator numberGenerator;

    public LottoShop(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createByBuyerLotto(int price) {
        Amount amount = new Amount(price);
        int lottoCount = amount.getLottoCount();

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(numberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public Lotto createByWinningLotto(List<Integer> inputLottoNumber) {
        return new Lotto(inputLottoNumber);
    }

    public BonusNumber createByBonusNumber(int number) {
        return new BonusNumber(number);
    }
}
