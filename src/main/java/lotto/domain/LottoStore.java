package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class LottoStore {
    private final int LOTTO_PRICE = 1000;
    private final int START_NUM = 1;
    private final int END_NUM = 45;
    private final int NUM_COUNT = 6;
    private final int MIN_PRICE = 1000;

    private long chargedMoney;
    private long lottoAmount;
    private List<Lotto> lottoPapers;

    public void getMoney(final long moneyInput) throws IllegalArgumentException{
        this.chargeMoney(moneyInput);
        validateChargedMoney();
    }


    public void chargeMoney(final long moneyInput) {
        this.chargedMoney = moneyInput;
    }

    public void validateChargedMoney() {
        if (this.chargedMoney < MIN_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_THOUSAND.errorMessage);
        }
        if (this.chargedMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVIDED_DISABLE.errorMessage);
        }
    }

    public void sellLottos(final Customer customer) {
        this.calculateLottoAmount();
        this.generateAllLottos();
        customer.getLotto(this.lottoPapers);
    }

    public void calculateLottoAmount() {
        this.lottoAmount = this.chargedMoney / LOTTO_PRICE;
    }

    public void generateAllLottos() {
        this.lottoPapers = new ArrayList<>();

        LongStream.range(0, this.lottoAmount)
                .forEach(i -> lottoPapers.add(generateLottoByNumbers(generateLottoNumbers())));
    }

    public Lotto generateLottoByNumbers(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> generateLottoNumbers() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, NUM_COUNT)
                .stream()
                .sorted()
                .toList();

        return numbers;
    }

    public long getLottoAmount() {
        return this.lottoAmount;
    }

    public long getChargedMoney() {
        return this.chargedMoney;
    }

    public List<Lotto> showLottoPapers() {
        return this.lottoPapers;
    }
}
