package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.constant.SystemNumbers.*;

public class LottoNumbers {

    private final PurchaseAmount purchaseAmount;
    private List<Lotto> drawnLottoNumbers;

    private LottoNumbers(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoNumbers validate(int purchaseAmount) {
        return new LottoNumbers(PurchaseAmount.validate(purchaseAmount));
    }

    public void drawnLottoNumbers() {
        drawnLottoNumbers = new ArrayList<>();
        int NumberOfLottos = purchaseAmount.calculateNumberOfLottos();
        IntStream.range(0, NumberOfLottos).mapToObj(i -> drawLottoNumber())
                .forEach(lotto -> drawnLottoNumbers.add(lotto));
    }

    private Lotto drawLottoNumber() {
        return Lotto.validate(generateRandomNumbers());
    }

    private List<Integer> generateRandomNumbers() {
        return pickUniqueNumbersInRange(MINIMUM_OF_NUMBER_RANGE.getNumber()
                , MAXIMUM_OF_NUMBER_RANGE.getNumber(), NUMBER_OF_WINNING_NUMBERS.getNumber());
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getPurchaseAmount();
    }

    public List<Lotto> getDrawnLottoNumbers() {
        return drawnLottoNumbers;
    }

}
