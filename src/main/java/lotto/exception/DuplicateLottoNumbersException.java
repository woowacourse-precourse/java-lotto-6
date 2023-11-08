package lotto.exception;

import lotto.io.LottoNumberReader;
import lotto.service.HasDuplicateService;

import java.util.List;

public class DuplicateLottoNumbersException extends RuntimeException {
    public static void checkForDuplicates(List<Integer> lottonumbers) {
        if (HasDuplicateService.hasDuplicates(lottonumbers)) {
            System.out.println("[ERROR]로또 번호에 중복된 값이 있습니다.");
            throw new DuplicateLottoNumbersException();
        }
    }
}

