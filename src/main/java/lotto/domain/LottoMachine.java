package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private  static  final int LOTTO_START_NUMBER = 1;//로또 시작 번호
    private  static  final int LOTTO_END_NUMBER = 45;//로또 마지막 번호
    private  static  final int LOTTO_NUMBER_SIZE = 6;//로또에 사용되는 번호 개수
    private final List<Integer> randomNumbers;

    //1~45 사이의 랜덤한 로또 번호 6개 생성
    private List<Integer> generateRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER,LOTTO_END_NUMBER,LOTTO_NUMBER_SIZE);
    }

    //생성된 로또 번호를 오름차순으로 정렬
    private List<Integer> sortRandomNumber(List<Integer> autoNumber){
        return autoNumber.stream().sorted().collect(Collectors.toList());
    }

    public LottoMachine(){
        this.randomNumbers = sortRandomNumber(generateRandomNumber());
    }

    public List<Integer> getRandomNumbers(){
        return randomNumbers;
    }
}
