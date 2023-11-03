package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateLottoNumbers {

    private static ArrayList<Integer> allLottos = new ArrayList<>();

    private List<Integer> generateEachLottoNumbers(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lottoNumbers;
    }

    private void generateAllLottos(int pieceOfLotto){
        for(int index = 0; index < pieceOfLotto; index++){
            allLottos.addAll(index,generateEachLottoNumbers());
        }
    }
    public ArrayList<Integer> getAllLottos(){
        return allLottos;
    }
}
