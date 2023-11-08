package lotto.core.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.console.Input;
import lotto.common.console.Output;
import lotto.common.exception.ErrorType;
import lotto.common.exception.LottoGameException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.core.domain.Lotto.LOTTO_SIZE;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public LottoGame() {}

    public void play(){
        // 1. 로또 구입 금액에 해당하는 만큼 로또를 발행한다.
        int lottoCount = getLottoCount();

        List<Lotto> lottos = makeLottos(lottoCount);

        // 2. 발행한 로또의 총 수량을 출력한다.
        writeLottoCount(lottoCount);

        // 3. 발행한 로또의 번호를 오름차순으로 정렬하여 출력한다.
        writeAllLottoNumbers(lottos);
    }

    private List<Lotto> makeLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(makeLottoNumbers()))
                .collect(Collectors.toList());
    }

    private int getLottoCount() {
        String purchaseAmount;

        do {
            purchaseAmount = Input.readPurchaseAmount();
        } while (!isValidPurchaseAmount(purchaseAmount));

        return Integer.parseInt(purchaseAmount) / LOTTO_PRICE;
    }

    private void writeLottoCount(int count) {
        Output.writeLottoCount(count);
    }

    private boolean isValidPurchaseAmount(String purchaseAmountInput) {
        try {
            int purchaseAmount = convertPurchaseAmount(purchaseAmountInput);
            validatePurchaseAmount(purchaseAmount);
            return true;
        } catch (IllegalArgumentException e) {
            Output.writeMessage(e.getMessage());
            return false;
        }
    }

    private int convertPurchaseAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw LottoGameException.withType(ErrorType.INVALID_PURCHASE_AMOUNT);
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount < 0 || purchaseAmount % LOTTO_PRICE != 0) {
            throw LottoGameException.withType(ErrorType.INVALID_PURCHASE_AMOUNT);
        }
    }

    //4. 로또 발행 시 중복되지 않는 숫자 6개를 뽑는다.
    public List<Integer> makeLottoNumbers() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(1, 45))
                .distinct()
                .limit(LOTTO_SIZE)
                .boxed()
                .collect(Collectors.toList());
    }

    private void writeAllLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(Output::writeLottoNumbers);
    }
}
