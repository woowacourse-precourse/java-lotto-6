package lotto;

        import java.util.List;
        import camp.nextstep.edu.missionutils.Randoms;
        import java.util.Collections;

        import java.util.List;

public class MakeRandomNumber {

    public List<Integer> getSixRandomNumbers(){
        List<Integer> sixNumber = Randoms.pickUniqueNumbersInRange(ConstantCollection.LOTTO_NUMBER_MIN,
                ConstantCollection.LOTTO_NUMBER_MAX, ConstantCollection.NUMBER_IN_LOTTO);
        Collections.sort(sixNumber);

        return sixNumber;
    }


}

