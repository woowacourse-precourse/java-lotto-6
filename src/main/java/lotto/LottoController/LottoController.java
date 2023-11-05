package lotto.LottoController;

import lotto.Lotto;
import lotto.LottoView.LottoView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoView view = new LottoView();
    private final List<Lotto> lotto = new ArrayList<>();

    private Lotto winNumbers;
    private int bonusNumber;

    public void run(){

    }

    public List<Integer> convertNumber(String input){
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String part : parts){
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }
}
