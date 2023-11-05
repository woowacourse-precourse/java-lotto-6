package lotto.DTO;

import java.util.List;

public class DrawWinNumberDTO {
    private List<Integer> winNumber;
    private int bonusNumber;

    public DrawWinNumberDTO(List<Integer> winNumber){
        this.winNumber = winNumber;
    }

    public List<Integer> getWinNumber(){
        return winNumber;
    }

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
