package lotto.DTO;

import java.util.List;

public class AutoTicketDTO {
    private int purchaseAmount;
    private int numberOfTicket;
    private List<Integer> autoTicket;

    public AutoTicketDTO(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurcahseAmount(){
        return purchaseAmount;
    }

    public void setAutoTicket(List<Integer> autoTicket){
        //입력 받은 문자열을 숫자 리스트로 바꾸는 모델 필요
        this.autoTicket = autoTicket;
    }

    public List<Integer> getAutoTicket(){
        return autoTicket;
    }

    public void setNumberOfTicket(int numberOfTicket){
        this.numberOfTicket = numberOfTicket;
    }

    public int getNumberOfTicket(){
        return numberOfTicket;
    }
}