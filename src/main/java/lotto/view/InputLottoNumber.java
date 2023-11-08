package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.DuplicateException;
import lotto.exception.NumberException;
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

    public String input() {
        System.out.println(INPUT_LOTTO_MESSAGE);
        return Console.readLine();
    }
    public List<Integer> getLottoNumbers() {
        boolean validInput=false;
        String lottoNumbs = finalValidate(validInput);
        return split(lottoNumbs);
    }

    private String finalValidate(boolean validInput) {
        String lottoNumbs = "";
        while (!validInput) {
            lottoNumbs = input();
            validateSize(lottoNumbs);
            validateNumber(lottoNumbs);
            validateDuplicate(lottoNumbs);
            validateRangeNumber(lottoNumbs);
            validInput=true;
        }
        return lottoNumbs;
    }
    private void validateNumber(String lottoNumbs) {
        if (!Pattern.compile("(\\d{1,2},){5}\\d{1,2}").matcher(lottoNumbs).matches()) {
            System.out.println(NumberException.NOT_NUMBER_ERROR_MESSAGE);
            throw new NumberException();
        }
    }

    private List<Integer> split(String lottoNumbs) {
        List<Integer> inputLottoNumber = new ArrayList<>();
        for (String i:lottoNumbs.split(",")) {
            inputLottoNumber.add(Integer.parseInt(i));
        }
        return inputLottoNumber;
    }

    private void validateRangeNumber(String lottoNumber) {
        List<Integer> lottoNumbs = split(lottoNumber);
        for (int number:lottoNumbs) {
            if (!checkNumberRange(number)) {
                System.out.println(RangeException.RANGE_ERROR_MESSAGE);
                throw new RangeException();
            }
        }
    }
    private void validateSize(String lottoNumber) {
        List<Integer> lottoNumbs = split(lottoNumber);
        if (lottoNumbs.size() != SIZE) {
            System.out.println(SizeException.SIZE_ERROR_MESSAGE);
            throw new SizeException();
        }
    }

    private void validateDuplicate(String lottoNumber) {
        List<Integer> lottoNumbs = split(lottoNumber);
        Set<Integer> lottoNumb = new HashSet<>(lottoNumbs);
        if (lottoNumb.size() != SIZE) {
            System.out.println(DuplicateException.DUPLICATE_ERROR_MESSAGE);
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