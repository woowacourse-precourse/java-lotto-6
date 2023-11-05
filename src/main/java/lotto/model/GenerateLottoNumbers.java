package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateLottoNumbers {
    private ArrayList<List<String>> allLottos = new ArrayList<>();
    /*
}

    public GenerateLottoNumbers(int pieceOfLotto){
        generateAllLottos(pieceOfLotto);
    }


    private List<String> generateEachLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6).stream().map(String::valueOf).toList();

    private void generateAllLottos(int pieceOfLotto){
        for(int index = 0; index < pieceOfLotto; index++){
            allLottos.add(generateEachLottoNumbers());
        }
    }
    public ArrayList<List<String>> getAllLottos(){
        return allLottos;
    }

     */
    private List<String> generateEachLotto(){
        return Randoms.pickUniqueNumbersInRange(1,45,6).stream().map(String::valueOf).toList();
    }

    private void generateAllLottos(int numberOfLotto){
        for(int i = 0; i < numberOfLotto; i++){
            allLottos.add(generateEachLotto());
        }
    }
    public ArrayList<List<String>> getAllLottos(){
        return allLottos;
    }
}
