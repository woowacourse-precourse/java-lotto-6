package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private final List<Lotto> userLottos = new ArrayList<>();
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber = 0;

    public List<Lotto> purchase (int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(sortAscendingOrder(lottoNumbers));
            userLottos.add(lotto);
        }
        return userLottos;
    }

    public void initWinningNumbers(String[] winningNumbers) {
        this.winningNumbers = Arrays.stream(winningNumbers)
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    public void initBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> sortAscendingOrder(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
