package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InsertLottoNumber {
    private final List<Integer> lotto;
    private int lottoNumber;
    private static final char LOTTO_NUMBER_MIN = '1';
    private static final char LOTTO_NUMBER_MAX = '9';

    public InsertLottoNumber(String number) {
        String[] lottoNumber = number.split(",");
        checkNumbeSize(lottoNumber);
        checkValidate(lottoNumber);
        checkDuplicate(lottoNumber);

        lotto = Arrays.stream(lottoNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void checkValidate(String[] number) {
        for (String count : number) {
            if (!validateNumber(count.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 다시 입력하세요.");
            }
        }
    }

    private void checkDuplicate(String[] number) {
        HashSet<Integer> duplicateNumber = new HashSet<>();

        for (String count : number) {
            int lottoNumber = Integer.parseInt(count);

            if (duplicateNumber.contains(lottoNumber))
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 발생했습니다.");

            duplicateNumber.add(lottoNumber);
        }
    }

    private void checkNumbeSize(String[] number) {
        for (String size : number) {
            if (size.length() != 1)
                throw new IllegalArgumentException("[ERROR] 한 글자가 아닙니다.");
        }
    }

    private boolean validateNumber(Character number) {
        return number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
    }

    public List<Integer> sendLottoNumber() {
        return lotto;
    }
}
