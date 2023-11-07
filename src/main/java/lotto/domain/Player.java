package lotto.domain;


import java.util.ArrayList;
import java.util.List;
import lotto.dto.response.LottosInfoDto;

public class Player {
    private final int money;
    private final LottoShop lottoShop;

    public Player(String input, LottoShop lottoShop) {
        this.money = Integer.parseInt(input);
        this.lottoShop = lottoShop;
    }

    public LottosInfoDto buyLottos() {
        LottosInfoDto lottosInfoDto = lottoShop.sellLottos(money);
        return lottosInfoDto;
    }

    public List<Integer> compareWinningAndLottoNumbers(List<Integer> winningNumbers) {
        Lottos lottos = new Lottos(buyLottos().lottosNumbers());
        List<Lotto> userLotto = lottos.getLottos();
        List<Integer> results = new ArrayList<>();

        for (Lotto lotto : userLotto) {
            int result = compareLotto(lotto, winningNumbers);
            results.add(result);
        }
        System.out.println(results);
        return results;
    }

    private int compareLotto(Lotto lotto, List<Integer> winningNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int result = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return result;
    }
}

