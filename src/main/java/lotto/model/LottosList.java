package lotto.model;

import static lotto.constant.Magic.END_INRANGE;
import static lotto.constant.Magic.LOTTO_PRICE;
import static lotto.constant.Magic.NUMBERS_INLOTTO;
import static lotto.constant.Magic.NUMBER_POSITIVE;
import static lotto.constant.Magic.STRAT_INRANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

public class LottosList {
    private List<Lotto> lottosList;

    private List<Boolean> bonusCheck;

    public LottosList() {
    }

    public LottosList(List<Lotto> lottos) throws IllegalArgumentException {
        this.lottosList = lottos;

    }

    public LottosList(String price) throws IllegalArgumentException {
        lottosList = new ArrayList<>();
        validatePricePositive(price);
        validatePrice1000(price);
        int lottoNum = calculateNumberLottos(price);
        createLottos(lottoNum);

    }

    private void validatePricePositive(String input) throws IllegalArgumentException {
        Matcher matcher = NUMBER_POSITIVE.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePrice1000(String input) throws IllegalArgumentException {
        int result = Integer.parseInt(input);
        
        if (result % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottosList() {
        return Collections.unmodifiableList(lottosList);
    }

    public void createLottos(int lottoNum) throws IllegalArgumentException {
        bonusCheck = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            List<Integer> numbers = generateUniqueNumbers();
            lottosList.add(new Lotto(numbers));
            bonusCheck.add(false);
        }
    }

    public int calculateNumberLottos(String price) {
        return Integer.parseInt(price) / LOTTO_PRICE;

    }

    public List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(STRAT_INRANGE, END_INRANGE, NUMBERS_INLOTTO);
    }

    public void checkBonus(int index) {
        bonusCheck.set(index, true);
    }

    public List<Boolean> getBonusCheck() {
        return bonusCheck;
    }


}
