package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinNumbers extends LottoNumber{
    private final static Integer WIN_NUMBERS_SIZE = 6;
    private final static String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개 입력되어야 합니다.";
    private final static String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호를 중복 없이 입력하셔야 합니다.";
    private List<Integer> winNumbers;

    public WinNumbers(String[] winNumbers) {
       super(winNumbers);
       this.winNumbers = new ArrayList<>();
       for(String winNumber : winNumbers) {
           this.winNumbers
                   .add(Integer.parseInt(winNumber));
       }
       validateSize(this.winNumbers);
       validateDuplication(this.winNumbers);
       sort();
    }

    private void validateSize(List<Integer> winNumbers) {
        if(winNumbers.size() != WIN_NUMBERS_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> winNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winNumbers);
        if(uniqueNumbers.size() != winNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void sort() {
        Collections.sort(this.winNumbers);
    }

    public List<Integer> getWinNumbers() {
        return this.winNumbers;
    }
}
