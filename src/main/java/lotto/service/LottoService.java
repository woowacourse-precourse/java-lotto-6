package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.utils.RandomGenerator;
import lotto.view.OutputView;

public class LottoService {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_AMOUNT = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoService() {
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
            int randomNumber = RandomGenerator.getRandomNumber(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }

    public void processStart(int payAmount) {
        int lottoCount = calculateLottoCount(payAmount);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }

        OutputView.printPaySuccessMessageMessage(lottoCount);
        OutputView.printLottos(lottos);

    }

    public int calculateLottoCount(int payAmount) {
        int lottoCount = payAmount / LOTTO_AMOUNT;
        return lottoCount;
    }
}
