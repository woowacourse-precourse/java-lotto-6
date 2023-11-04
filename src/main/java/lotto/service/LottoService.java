package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.repository.LottoRepository;
import lotto.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository = new LottoRepository();
    private List<Integer> numbers;

    private static final int LEAST_AMOUNT = 1000;
    private static final int MIN_NUMBER = 0;
    private static final int COUNT_ONE = 1;


    public void buyLottoAtOnce(User user){
        int count = user.getPurchaseAmount() / LEAST_AMOUNT;
        while (count > 0){
            count--;
            buyOneLotto(user);
        }
    }
    public void saveLotto(Lotto lotto){
        lottoRepository.save(lotto);
    }

    public void buyOneLotto(User user){
        Lotto lotto = generateLottoNumber();
        saveLotto(lotto);
    }



    //Lotto안에 넣어야 자동 검증
    private Lotto generateLottoNumber(){
        numbers.clear();
        numbers = new ArrayList<>(Utils.generateRandomUniqueNumber());
        return new Lotto(numbers);
    }

    public int countContainNumber(List<Integer> list, int number){
        if(list.contains(number)){
            return COUNT_ONE;
        }
        return MIN_NUMBER;
    }
    public int countMatchNumber(List<Integer> list1, List<Integer> list2){
        int count = MIN_NUMBER;
        for(int number : list2){
            count += countContainNumber(list1,number);
        }
        return count;
    }


}
