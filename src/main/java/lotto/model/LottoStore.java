package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.UserInputValidator;

public class LottoStore {
    private static List<Lotto> lottoList;
    private static int lottoCount;

    public List<Lotto> buyLottos(String userInput) {
        int amount = getPurchaseAmount(userInput);
        lottoCount = calculateAttemptCount(amount);
        lottoList = generateLottoList();
        return lottoList;
    }

    public static int getPurchaseAmount(String userInput) throws IllegalArgumentException {
        try {
            int amount = UserInputValidator.validatePurchaseAmount(userInput);
            return amount;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private static int calculateAttemptCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static List<Lotto> generateLottoList() {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }

    private static Lotto generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator.generateLotto());
        return lotto;
    }


}
