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
    private List<Integer> inputLottoNumber = new ArrayList<>();
    boolean flag=false;

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
            if (validException(lottoNumbs)) continue;
            validInput=true;
        }
        return lottoNumbs;
    }

    private boolean validException(String lottoNumbs) {
        if (!validateSplit(lottoNumbs)) {
            return true;
        }
        if (!validateSize(inputLottoNumber)) {
            return true;
        }
        if (!validateNumber(lottoNumbs)) {
            return true;
        }
        if (!validateDuplicate(inputLottoNumber)) {
            return true;
        }
        if (!validateRangeNumber(inputLottoNumber)) {
            return true;
        }
        return false;
    }

    private boolean validateSplit(String lottoNumbs) {
        for (String i:lottoNumbs.split(",")) {
            try {
                Integer.parseInt(i);
            } catch (NumberFormatException e) {
                System.out.println(NumberException.NOT_NUMBER_ERROR_MESSAGE);
                return false;
            }
            inputLottoNumber.add(Integer.parseInt(i));
        }
        return true;
    }

    private boolean validateNumber(String lottoNumbs) {
        if (!Pattern.compile("(\\d{1,2},){5}\\d{1,2}").matcher(lottoNumbs).matches()) {
            System.out.println(NumberException.NOT_NUMBER_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private List<Integer> split(String lottoNumbs) {
        List<Integer> inputLottoNumber = new ArrayList<>();
        for (String i:lottoNumbs.split(",")) {
            try {
                Integer.parseInt(i);
            } catch (NumberFormatException e) {
                System.out.println(NumberException.NOT_NUMBER_ERROR_MESSAGE);
                break;
            }
            inputLottoNumber.add(Integer.parseInt(i));
        }
        return inputLottoNumber;
    }

    private boolean validateRangeNumber(List<Integer> lottoNumber) {
        for (int number:lottoNumber) {
            if (!checkNumberRange(number)) {
                System.out.println(RangeException.RANGE_ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    private boolean validateSize(List<Integer> lottoNumber) {
        if (lottoNumber.size() != SIZE) {
            System.out.println(SizeException.SIZE_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validateDuplicate(List<Integer> lottoNumber) {
        Set<Integer> lottoNumb = new HashSet<>(lottoNumber);
        if (lottoNumb.size() != SIZE) {
            System.out.println(DuplicateException.DUPLICATE_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean checkNumberRange(int number) {
        if (number >= MIN && number <= MAX) {
            return true;
        }
        return false;
    }

}