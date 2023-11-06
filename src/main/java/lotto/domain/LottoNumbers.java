package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.NumberUtil;
import lotto.service.PrintUtil;
import lotto.validation.LottoNumberValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private StringBuilder sb = new StringBuilder();

    LottoNumberValidation lottoNumberValidation = new LottoNumberValidation();

    PrintUtil printUtil = new PrintUtil();

    public Lotto[] pickLottoNumbers(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / NumberUtil.LOTTO_PRICE.getNumber();
        printUtil.printNumberOfLotto(numberOfLotto);

        Lotto[] lottos = IntStream.range(0, numberOfLotto)
                .mapToObj(count -> pickRandomLottoNumbers())
                .toArray(Lotto[]::new);

        printUtil.printLottoNumbers(sb);

        return lottos;
    }

    public Lotto pickRandomLottoNumbers() {
        Lotto lottoNumbers;
        do {
            lottoNumbers = new Lotto(Randoms.pickUniqueNumbersInRange(
                    NumberUtil.START_NUMBER.getNumber(),
                    NumberUtil.END_NUMBER.getNumber(),
                    NumberUtil.LOTTO_COUNT_LIMIT.getNumber()));
        } while (isDuplicateLottoNumbers(lottoNumbers));

        return lottoNumbers;
    }

    public boolean isDuplicateLottoNumbers(Lotto lottoNumbers) {
        try {
            lottoNumberValidation.validateDuplicateLottoNumbers(lottoNumbers);
            synthesizeLottoNumbers(lottoNumbers);
            return false;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
    }

    public void synthesizeLottoNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getLottoNumbers());
        Collections.sort(lottoNumbers);

        String result = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

        sb.append(result).append("\n");
    }
}
