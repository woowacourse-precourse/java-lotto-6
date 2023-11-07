package lotto;
import java.util.List;


public class WinningCalcuation {
    public int checking = 0;
    public boolean bonuschk = false;

    public void winningCheck(List<LotteryMachine>winCheck,List<Lotto>customerCheck,BonusLotto bonusCheck) {
        for(LotteryMachine win:winCheck) {
            for(Lotto customer : customerCheck){
                if(win.equals(customer)){
                    checking+=1;
                }
                break;
            }
        }
        for(Lotto customer : customerCheck){
            if(customer.equals(bonusCheck)){
                bonuschk = true;
                checking +=1;
            }
        }
    }
}

