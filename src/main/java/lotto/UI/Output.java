package lotto.UI;

import java.util.List;

public class Output {

    public void printRandomLottoNumbers (List<List<Integer>> randomLottoNumbers){
        for (List<Integer> randomLottoNumber : randomLottoNumbers){
            System.out.println(randomLottoNumber);
        }
    }
}
