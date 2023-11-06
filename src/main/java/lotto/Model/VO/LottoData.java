package lotto.Model.VO;

import java.util.ArrayList;
import java.util.List;

public class LottoData {
    public final ArrayList<Integer> numbers;
    public LottoData(List<Integer> data){
        numbers = new ArrayList<>(data);
    }
}
