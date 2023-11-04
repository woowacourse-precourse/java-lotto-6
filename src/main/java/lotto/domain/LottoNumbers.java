package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.PrintUtil;
import lotto.validation.LottoNumberValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private StringBuilder sb = new StringBuilder();

    private Lotto lotto;

    LottoNumberValidation lottoNumberValidation = new LottoNumberValidation();

    PrintUtil printUtil = new PrintUtil();

    public void pickLottoNumbers(int numberOfLotto) {
        printUtil.printNumberOfLotto(numberOfLotto);

        List<Integer> lottoNumbers = new ArrayList<>();
        for (int count = 0; count < numberOfLotto; count++) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Collections.sort(lottoNumbers);
            if(isDuplicateLottoNumbers(lottoNumbers)) count--;
        }

        printUtil.printLottoNumbers(sb);
    }

    public boolean isDuplicateLottoNumbers(List<Integer> lottoNumbers) {
        try {
            lottoNumberValidation.validateDuplicateLottoNumbers(lottoNumbers);
            synthesizeLottoNumbers(lottoNumbers);
            return false;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
    }
    public void synthesizeLottoNumbers(List<Integer> lottoNumbers) {
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
