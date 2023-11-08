package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final int pricePerLotto = 1000;
    private final int lottoNumberCount = 6;
    private final int minLottoNumber = 1;
    private final int maxLottoNumber = 45;



    public void launch() {
        User user = new User();
        Result result = new Result();

        try {
            int purchaseAmount = user.inputValidatedPurchaseAmount(this);
            List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
            result.printNumberOfLottosPurchased(purchasedLottos.size());
            result.printPurchasedLottos(purchasedLottos);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());

        }

    }

    public boolean verifyPurchaseAmount(int purchaseAmount) {
        return isValidPurchaseAmount(purchaseAmount);
    }
    private boolean isValidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount % pricePerLotto == 0;
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / pricePerLotto;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, lottoNumberCount);
        return new Lotto(numbers);
    }

}
