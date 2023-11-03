package lotto;

import camp.nextstep.edu.missionutils.Randoms;

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

    public void getMoney(final String moneyInput) throws IllegalArgumentException{
        this.validateMoneyInput(moneyInput);
        this.chargeMoney(moneyInput);
        validateChargedMoney();
    }


    public void validateMoneyInput(final String moneyInput) {
        moneyInput.chars().forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        });
    }

    public void chargeMoney(final String moneyInput) {
        this.chargedMoney = Long.parseLong(moneyInput);
    }

    public void validateChargedMoney() {
        if (this.chargedMoney < MIN_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 부터입니다.");
        }
        if (this.chargedMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위 입니다.");
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
}
