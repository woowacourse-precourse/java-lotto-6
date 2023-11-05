package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoView lottoView = new LottoView();

    /**
     * 로또 진행
     */
    public void processLottoWinning() {
        ArrayList<Integer> winningNumbers; // 로또 당첨 번호
        int bonusNumber;
        int amount = lottoView.inputPurchaseAmount() / 1000;

        Lotto[] lottos = new Lotto[amount];
        for (int i = 0; i < lottos.length; ++i) {
            lottos[i] = new Lotto(generateLottoNumbers());
        }
        lottoView.printPurchasedLottoNumbers(lottos);

        winningNumbers = generateLottoWinningNumbers(lottoView.inputWinningNumber());
        bonusNumber = lottoView.inputBonusNumber();

    }


    /**
     * 로또 번호 생성
     */
    public List<Integer> generateLottoNumbers() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);
        return lotto;
    }

    /**
     * 로또 당첨 번호 생성
     */
    public ArrayList<Integer> generateLottoWinningNumbers(String winningNumbers) {
        String[] winningNumber = winningNumbers.split(",");
        return Arrays.stream(winningNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
