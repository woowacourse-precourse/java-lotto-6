package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Integer> numbers = new ArrayList<>();
    private int matchingCount;
    private boolean bonusNumberMatch = false;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }
    public void printNumbers() {
        System.out.println(numbers);
    }

}
