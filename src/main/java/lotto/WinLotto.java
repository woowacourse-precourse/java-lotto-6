package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLotto {
    public Lotto winLotto;
    public int bonus;

    public List<Integer> WinLottoNumbers;

    public WinLotto(){
        setWinLotto();
    }

    public List<Integer> inputWinNum(){
        String rawInputWinNum = Console.readLine();
        validRawWinNum(rawInputWinNum);
        String[] rawWinNum = rawInputWinNum.split(",");

        List<Integer> winNum = new ArrayList<>();
        for(int i = 0; i<rawWinNum.length; i++){
            winNum.add(Integer.parseInt(rawWinNum[i]));
        }
        validWinNum(winNum);

        return winNum;
    }

    public void validRawWinNum(String raw){
        if(!raw.replaceAll(",", "").matches("^[0-9]*$")){
            throw new IllegalArgumentException("[ERROR] ,로 구분된 입력값을 입력해야 합니다.");
        }
    }

    public void validWinNum(List<Integer> winNum){
        Set<Integer> removeDuplicate = new HashSet<>(winNum);
        if(winNum.size() != removeDuplicate.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다.");
        }

        for(int i = 0; i<winNum.size(); i++){
            validRange(winNum.get(i));
        }
    }

    public void setWinLotto(){
        WinLottoNumbers = inputWinNum();
        winLotto = new Lotto(WinLottoNumbers);
    }

    public void setBonus(){
        int inputBonus = Integer.parseInt(Console.readLine());
        validRange(inputBonus);
        validDuplicateBonus(inputBonus);
        bonus = inputBonus;
    }

    public void validDuplicateBonus(int bonus){
        if(WinLottoNumbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다.");
        }
    }
    public void validRange(int num){
        if(num > 45){
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자여야 합니다. ");
        }
    }
}
