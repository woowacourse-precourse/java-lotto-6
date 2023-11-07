package lotto;

import config.LottoConfig;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class LottoChecker {
    private final HashSet<Integer> answerNumberSet;
    private final int bonusNumber;

    public LottoChecker(String answerNumberSetInput, String bonusNumberInput) {
        this.answerNumberSet = parseLottoNumberSet(answerNumberSetInput);
        this.bonusNumber = parseLottoNumber(bonusNumberInput);

        if (answerNumberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public List<LottoPrize> check(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::getPrize)
                .toList();
    }

    private LottoPrize getPrize(Lotto lotto) {
        int hit = 0;
        for (int number : lotto.getNumbers()) {
            if (answerNumberSet.contains(number)) {
                hit++;
            }
        }

        if (hit == LottoConfig.LOTTO_SIZE) {
            return LottoPrize.FIRST;
        }
        if (hit == LottoConfig.LOTTO_SIZE - 1 && lotto.getNumbers().contains(bonusNumber)) {
            return LottoPrize.SECOND;
        }
        if (hit == LottoConfig.LOTTO_SIZE - 1) {
            return LottoPrize.THIRD;
        }
        if (hit == LottoConfig.LOTTO_SIZE - 2) {
            return LottoPrize.FOURTH;
        }
        if (hit == LottoConfig.LOTTO_SIZE - 3) {
            return LottoPrize.FIFTH;
        }
        return LottoPrize.NONE;
    }

    private HashSet<Integer> parseLottoNumberSet(String lottoNumberInput) {
        try {
            List<Integer> lottoNumberList = Stream.of(lottoNumberInput.split(",")).map(this::parseLottoNumber).toList();
            if (lottoNumberList.size() != LottoConfig.LOTTO_SIZE) {
                throw new IllegalArgumentException(String.format("[ERROR] 당첨 번호는 %d개여야 합니다.", LottoConfig.LOTTO_SIZE));
            }
            HashSet<Integer> lottoNumberSet = new HashSet<>(lottoNumberList);
            if (lottoNumberSet.size() != LottoConfig.LOTTO_SIZE) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
            }
            return lottoNumberSet;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 숫자로만 입력해야 합니다.");
        }
    }

    private int parseLottoNumber(String numberString) {
    	try {
            int number = Integer.parseInt(numberString);
            validateLottoNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 숫자로만 입력해야 합니다.");
        }
    }

    private void validateLottoNumber(int number) {
        if (number < LottoConfig.LOTTO_MIN || number > LottoConfig.LOTTO_MAX) {
            throw new IllegalArgumentException(String.format("[ERROR] 각각의 당첨 번호는 %d~%d 사이여야 합니다.", LottoConfig.LOTTO_MIN, LottoConfig.LOTTO_MAX));
        }
    }
}
