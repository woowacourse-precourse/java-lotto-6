package lotto.model;

import lotto.validate.InvalidlputException;

import java.util.*;

public class PirzeResult {

    private Lotto winningLottoNumber;
    private int bonusNumber;
    private int sameNumber;
    private int sameBonus;

    public List<Integer> splitNumber(String inputNumber){
        String[] temp = inputNumber.split(",");
        List<Integer> winningLottoNumber = new ArrayList<>();
        for (int i=0; i<temp.length; i++){
            winningLottoNumber.add(Integer.parseInt(temp[i]));
        }
        return winningLottoNumber;
    }

    public int checkLottoNumber(List<Integer> numbers, List<Integer> winningLottoNumber){
        for(int i=0; i<winningLottoNumber.size(); i++){
            if(winningLottoNumber.contains(numbers.get(i))){
                sameNumber++;
            }
        }
        return sameNumber;
    }

    public int checkLottoBonus(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)){
            sameBonus++;
        }
        return sameBonus;
    }

    private final Map<PrizeMoney, Integer> result =  new EnumMap<>(PrizeMoney.class);
    private long ticket;

    public void searchWinning(PrizeMoney prizeMoney){
        result.put(prizeMoney, result.getOrDefault(prizeMoney, 0 )+1);
    }

    public int checkCountWinning(PrizeMoney prizeMoney){
        return result.getOrDefault(prizeMoney,0);
    }





}
