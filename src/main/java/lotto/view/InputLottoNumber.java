package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.DuplicateException;
import lotto.exception.RangeException;
import lotto.exception.SizeException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;


public class InputLottoNumber {

    private static final String INPUT_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final int MIN=1;
    private static final int MAX=45;
    private static final int SIZE=6;


    public List<Integer> getLottoNumbers() {
        System.out.println(INPUT_LOTTO_MESSAGE);
        String lottoNumbs = Console.readLine();
        System.out.println();
        validate(lottoNumbs);
        List<Integer> lottoNumb = split(lottoNumbs);
        validateSize(lottoNumb);
        validateLottoNumber(lottoNumb);
        validateDuplicate(lottoNumb);
        return lottoNumb;
    }

    private void validate(String lottoNumbs) {
        if (!Pattern.compile("(\\d{1,2},){5}\\d{1,2}").matcher(lottoNumbs).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> split(String lottoNumbs) {
        List<Integer> inputLottoNumber = new ArrayList<>();
        for (String i:lottoNumbs.split(",")) {
            inputLottoNumber.add(Integer.parseInt(i));
        }
        return inputLottoNumber;
    }

    private void validateLottoNumber(List<Integer> lottoNumbs) {
        for (int number:lottoNumbs) {
            if (!checkNumberRange(number)) {
                throw new RangeException();
            }
        }
    }
    private void validateSize(List<Integer> lottoNumbs) {
        if (lottoNumbs.size() != SIZE) {
            throw new SizeException();
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbs) {
        Set<Integer> lottoNumb = new HashSet<>(lottoNumbs);
        if (lottoNumb.size() != SIZE) {
            throw new DuplicateException();
        }
    }

    private boolean checkNumberRange(int number) {
        if (number >= MIN && number <= MAX) {
            return true;
        }
        return false;
    }

}