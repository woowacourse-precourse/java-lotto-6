package lotto.model;

import static lotto.ErrorMessage.NOT_NUMBER_WIN_FORMAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoValidator;
import lotto.view.OutPutView;

public class WinNumbers {
    private final List<Integer> winNumbers;

    private WinNumbers(List<Integer> numbers) {
        this.winNumbers = numbers;
    }

    public static WinNumbers createWinNumbers(String numbers) {
        if (isValid(numbers)) {
            List<Integer> winNumbers= toIntegerList(StringToList(numbers));
            return new WinNumbers(winNumbers);
        }
        return null;
    }

    private static boolean isValid(String numbers) {
        List<Integer> winNumbers = toIntegerList(StringToList(numbers));
        if(winNumbers==null){
            return false;
        }
        return LottoValidator.isOverSize(winNumbers)
                && LottoValidator.isDuplicateNumber(winNumbers)
                && LottoValidator.isNumbersInRange(winNumbers);
    }

    private static List<String> StringToList(String numbers) {
        return Arrays.asList(numbers.split(","));
    }

    private static List<Integer> toIntegerList(List<String> numbers){
        List<Integer> winNumbers = new ArrayList<Integer>();
        for(String number : numbers){
            if(!isInt(number)){
                OutPutView.println(NOT_NUMBER_WIN_FORMAT.getMessage());
                return null;
            }
            winNumbers.add(Integer.parseInt(number));
        }
        return winNumbers;
    }
    private static boolean isInt(String number){
        return number.matches("\\d+");
    }

    public List<Integer> getNumbers() {
        return winNumbers;
    }
}
