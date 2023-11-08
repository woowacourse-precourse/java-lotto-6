package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateLottoNumbers {
    private ArrayList<List<String>> allLottos = new ArrayList<>();

    public GenerateLottoNumbers(int numberOfLotto){
        generateAllLottos(numberOfLotto);
    }
    private List<String> generateEachLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        List<String> lottoNumbers = numbers.stream().map(String::valueOf).toList();

        return lottoNumbers;
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
