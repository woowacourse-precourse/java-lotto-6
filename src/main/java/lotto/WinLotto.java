package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLotto {
    public Lotto winLotto;

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
            throw new IllegalArgumentException();
        }
    }

    public void validWinNum(List<Integer> winNum){
        Set<Integer> removeDuplicate = new HashSet<>(winNum);
        if(winNum.size() != removeDuplicate.size()){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i<winNum.size(); i++){
            if(winNum.get(i) > 45){
                throw new IllegalArgumentException();
            }
        }
    }

    public void setWinLotto(){
        winLotto = new Lotto(inputWinNum());
    }


}
