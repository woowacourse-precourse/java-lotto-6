package lotto;

import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final Set<Integer> numbers;
    private final int bonusNumber;

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public WinningNumber(Set<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
public ERating count(Lotto lottoTicket){
        double count=0;
        for(int ticketNumber:lottoTicket.getNumbers()){
            if(numbers.contains(ticketNumber))count++;
            if(ticketNumber==bonusNumber) count=count+0.5;
        }
        if(count>5.5) return ERating.eFIRST;
        if(count>5) return ERating.eSECOND;
        if(count>4.5) return ERating.eTHIRD;
        if(count>3.5) return ERating.eFOURTH;
        if(count>2.5) return ERating.eFIFTH;
    return ERating.eSIXTH;
}


}
