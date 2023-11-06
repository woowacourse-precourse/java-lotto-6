package lotto.Model.VO;

import java.util.ArrayList;
import java.util.List;

public class LottoData {
    private final ArrayList<Integer> numbers;
    public LottoData(List<Integer> data){
        numbers = new ArrayList<>(data);
    }
    public ArrayList<Integer> getNumbers(){
        return numbers;
    }
}