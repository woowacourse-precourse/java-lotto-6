package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMaker {
    private static final int ONE_LOTTO_PRICE = 1000;
    private final LottoNumberMaker lottoNumberMaker;

    public LottoMaker() {
        this(new LottoNumberMaker());
    }

    public LottoMaker(LottoNumberMaker lottoNumberMaker) {
        this.lottoNumberMaker = lottoNumberMaker;
    }

    public WinningLotto createWinningLottoFromInput(String numbers, int bonusNumber) {
        return new WinningLotto(lottoNumberMaker.createByInput(numbers), bonusNumber);
    }

    public Lotto createOneLotto() {
        List<Integer> lottoNumbers = lottoNumberMaker.createLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> createLottosByPrice(int price) {
        validatePrice(price);
        int lottosCount = price / ONE_LOTTO_PRICE;

        return createLottosByCount(lottosCount);
    }

    private void validatePrice(int price) {
        if (price % ONE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 천원 단위여야 합니다.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
        }
    }

    private List<Lotto> createLottosByCount(int lottosCount) {
        return IntStream.rangeClosed(1, lottosCount)
                .mapToObj(order -> createOneLotto())
                .toList();
    }
}
