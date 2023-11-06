package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.PrintUtil;
import lotto.validation.LottoNumberValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private StringBuilder sb = new StringBuilder();

    LottoNumberValidation lottoNumberValidation = new LottoNumberValidation();

    PrintUtil printUtil = new PrintUtil();

    public Lotto[] pickLottoNumbers(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        printUtil.printNumberOfLotto(numberOfLotto);

        Lotto[] lottos = new Lotto[numberOfLotto];
        for (int count = 0; count < numberOfLotto; count++) {
            lottos[count] = pickRandomLottoNumbers();
        }
        printUtil.printLottoNumbers(sb);

        return lottos;
    }

    public Lotto pickRandomLottoNumbers() {
        Lotto lottoNumbers;
        do {
            lottoNumbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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

        sb.append("[");
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                sb.append(lottoNumbers.get(i)).append("]").append("\n");
                return;
            }
            sb.append(lottoNumbers.get(i)).append(", ");
        }
    }
}
