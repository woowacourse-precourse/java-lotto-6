package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumberInPut {
    static final String SPLIT_DELIMITER = ",";
    static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String ERROR_LOTTO_LIST_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자 여야 합니다.";
    static final String ERROR_LOTTO_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개 여야 합니다.";
    static final String ERROR_LOTTO_DUPLICATION_MESSAGE = "[ERROR] 로또 번호는 중복 없이 입력 하여야 합니다.";

    public static List<Integer> getLottoNumbers() {

        List<Integer> LottoNumsList = LottoNumberInPut.lottoNumbers();
        LottoNumberInPut.lottoNumberListValidator(LottoNumsList);
        LottoNumberInPut.lottoNumberSizeValidator(LottoNumsList);
        LottoNumberInPut.lottoNumberDuplicationValidator(LottoNumsList);

        return LottoNumsList;
    }

    public static List<Integer> lottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
        String input = Console.readLine();
        List<Integer> lottoNumbersList = new ArrayList<>();

        for (String numbers : input.split(SPLIT_DELIMITER)) {
            lottoNumbersList.add(Integer.parseInt(numbers));
        }
        System.out.println(lottoNumbersList);
        return lottoNumbersList;
    }

    public static void lottoNumberListValidator(List<Integer> lottoNumbers) {
        try {
            for (Integer numbers : lottoNumbers) {
                if (numbers < 1 || numbers > 45) {
                    throw new IllegalArgumentException(ERROR_LOTTO_LIST_MESSAGE);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getLottoNumbers();
        }
    }

    public static void lottoNumberSizeValidator(List<Integer> lottoNumbers) {
        try {
            new lotto.input.Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_LOTTO_SIZE_MESSAGE);
            getLottoNumbers();
        }
    }

    public static void lottoNumberDuplicationValidator(List<Integer> lottoNumbers) {
        try {
            for (int i = 0; i < lottoNumbers.size() -1; i++) {
                for (int j = 1 + i; j < 6; j++) {
                    if (Objects.equals(lottoNumbers.get(i), lottoNumbers.get(j))) {
                        throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATION_MESSAGE);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getLottoNumbers();
        }
    }
}