package lotto.DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoTicketDTO {
    private int purchaseAmount;
    private int numberOfTicket;
    Map<Integer, List<Integer>> autoTicket = new HashMap<>();

    public AutoTicketDTO(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurcahseAmount() {
        return purchaseAmount;
    }

    public void setAutoTicket(int index, List<Integer> autoTicket) {
        this.autoTicket.put(index, autoTicket);
    }

    public List<Integer> getAutoTicket(int index) {
        return autoTicket.get(index);
    }

    public void setNumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }
}