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
