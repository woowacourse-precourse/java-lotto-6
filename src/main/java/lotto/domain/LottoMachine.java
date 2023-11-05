package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> winningNumbers; //매주 토요일 오후 8시 35분
    private int bonusNum;
    private static final LottoMachine instance = new LottoMachine();

    private LottoMachine() {}

    public static LottoMachine getInstance() {
        return instance;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validateLottoNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setBonusNum(Integer bonusNum) {
        validateBonusNumber(bonusNum);
        this.bonusNum = bonusNum;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }

    public int calculateNumberOfTickets(int paidAmount) {
        validatePurchaseAmount(paidAmount);
        return paidAmount / LOTTO_PRICE;
    }

    public List<Lotto> purchaseLottos(int cash) {
        int numberOfLottos = calculateNumberOfTickets(cash);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(RandMachine.generateRandomNumbers()));
        }
        return lottos;
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("지불한 금액이 로또 가격보다 적습니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateBonusNumber(int number) {
        validateNumberInRange(number);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private void validateNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }
}
