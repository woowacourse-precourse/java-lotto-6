package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoInfo;

import java.util.ArrayList;
import java.util.List;

import static lotto.Input.getNaturalNumber;
import static lotto.Input.getSplitNaturalNumberList;

public class LottoMachine {
    private final int MIN_NUMBER;
    private final int MAX_NUMBER;
    private final int NUMBERS_PER_LOTTO;
    private final int LOTTO_PRICE;

    LottoMachine() {
        this.MIN_NUMBER = LottoInfo.MIN_NUMBER.getNumber();
        this.MAX_NUMBER = LottoInfo.MAX_NUMBER.getNumber();
        this.NUMBERS_PER_LOTTO = LottoInfo.NUMBERS_PER_LOTTO.getNumber();
        this.LOTTO_PRICE = LottoInfo.LOTTO_PRICE.getNumber();
    }

    public void run() {
        int lottoCount = setLottoCount();
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<List<Integer>> myLottos = getAllLotto(lottoCount);
        System.out.println(lottoToString(myLottos));
        Lotto lotto = setWinningNumbers();
        int bonus = setBonusNumber(lotto);
    }

    public int setLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int number = getNaturalNumber();
                Validation.validateMultipleOfLottoPrice(number);
                return number/LOTTO_PRICE;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<List<Integer>> getAllLotto(int count) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ret.add(getLotto());
        }
        return ret;
    }

    public String lottoToString(List<List<Integer>> lottos) {
        StringBuilder ret = new StringBuilder();
        lottos.forEach(i -> {
            ret.append(i.toString());
            ret.append("\n");
        });
        return ret.toString().trim();
    }

    private Lotto setWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                List<Integer> numbers = getSplitNaturalNumberList(",");
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int setBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int number = getNaturalNumber();
                Validation.validateDuplicate(lotto, number);
                return number;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getLotto() {
        List<Integer> ret = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_PER_LOTTO);
        return ret.stream().sorted().toList();
    }
}
