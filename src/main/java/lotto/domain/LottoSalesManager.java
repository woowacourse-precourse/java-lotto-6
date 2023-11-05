package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessages;

public class LottoSalesManager {
    private final int amount;

    public LottoSalesManager(String unParsedAmount) {
        checkIsValid(unParsedAmount);
        this.amount = Integer.parseInt(unParsedAmount);
    }

    private void checkIsValid(String unParsedAmount) {
        int parsedAmount = 0;
        try{
            parsedAmount = Integer.parseInt(unParsedAmount);
            //TODO error구체화
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(ErrorMessages.CAN_NOT_CONVERT_TO_NUMBER.getMessage());
        }
        if(parsedAmount % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessages.NOT_A_MULTIPLE_OF_1000.getMessage());
        }
    }

    public List<Lotto> makeLottos(){
      List<Lotto> lottos = new ArrayList<>();
      for(int i = 0; i < amount/1000; i++){
          lottos.add(new Lotto(makeRandomNumbers()));
      }
      return lottos;
    }

    private List<Integer> makeRandomNumbers() {
        while(true){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Set<Integer> numbersWithDuplicatesRemove = new HashSet<>(numbers);
            if(numbersWithDuplicatesRemove.size() == 6){
                return numbers;
            }
        }
    }

}
