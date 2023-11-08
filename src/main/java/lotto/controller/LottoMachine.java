package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;

public class LottoMachine {
    private static final int PAYMENT_UNIT = 1000;

    private final Map<Integer, LottoResult> lottoResults;

    public LottoMachine() {
        this.lottoResults = new HashMap<>();
    }

    public static List<Lotto> getLottoNumberList(int purchaseAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        int bundleNum = purchaseAmount / PAYMENT_UNIT;
        for (int i = 0; i < bundleNum; ++i) {
            Lotto lotto = new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            Collections.sort(lotto.getNumbers());
            lottoNumbers.add(lotto);
        }

        return lottoNumbers;
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        lottoNumbers.stream()
                .map(lotto -> lotto.getNumbers())
                .forEach(System.out::println);
    }

    public LottoResult getLottoResult() {
        Broardcaster broardcaster = new Broardcaster();
        List<Integer> lottoNumbers = broardcaster.choiceLotteryNumbers();
        int bonusNumber = broardcaster.choiceBonusNumber(lottoNumbers);

        LottoResult lottoResult = LottoResult.from(new Lotto(lottoNumbers), bonusNumber);
        addLottoResult(lottoResult);
        return lottoResult;
    }

    private void addLottoResult(LottoResult lottoResult) {
        lottoResults.put(lottoResults.size() + 1, lottoResult);
    }
}
