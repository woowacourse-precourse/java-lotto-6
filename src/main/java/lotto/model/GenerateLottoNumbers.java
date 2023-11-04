package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateLottoNumbers {

    public GenerateLottoNumbers(int pieceOfLotto){
        generateAllLottos(pieceOfLotto);
    }
    private ArrayList<List<Integer>> allLottos = new ArrayList<List<Integer>>();

    private List<Integer> generateEachLottoNumbers(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lottoNumbers;
    }

    private void generateAllLottos(int pieceOfLotto){
        for(int index = 0; index < pieceOfLotto; index++){
            allLottos.add(generateEachLottoNumbers());
        }
    }
    public ArrayList<List<Integer>> getAllLottos(){
        return allLottos;
    }
}
