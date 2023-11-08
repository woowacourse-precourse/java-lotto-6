package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class GenLotto {
    private static final int Count = 6;
    private static List<Lotto> Lottos;
    public List<Lotto> makeLottoNum(int Chance){
        Lottos = new ArrayList<>();
        for(int i = 0;i<Chance;i++){
            Lottos.add(makelotto());
        }
        return Lottos;
    }
    private static Lotto makelotto(){
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);
        printLottos(lotto);
        return new Lotto(lotto);
    }
    public static void printLottos(List<Integer> lotto){
        PrintOutput printOutput = new PrintOutput();
        printOutput.printLottoList(lotto);
    }
}
