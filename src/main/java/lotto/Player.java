package lotto;
import static camp.nextstep.edu.missionutils.Console.*;

public class Player {
    private int ticketPrice;
    private int  MyTicketCount;

    public int payTicketPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String ticketPriceInput = readLine();
        validateTicketPrice(ticketPriceInput);
        this.ticketPrice = Integer.parseInt(ticketPriceInput);
        return this.ticketPrice;
    }

    private void validateTicketPrice(String ticketPriceInput) {
        for (int index = 0; index < ticketPriceInput.length(); index++) {
            if (!Character.isDigit(ticketPriceInput.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
            }
        }

        int ticketPrice = Integer.parseInt(ticketPriceInput);

        if(ticketPrice%1000!=0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하여 주십시오.");
        }
    }

    public int getMyTicketCount(){
        this.MyTicketCount = this.ticketPrice/1000;
        return this.MyTicketCount;
    }

    public void printMyTicketCount(){
        System.out.println("\n"+this.MyTicketCount+"개를 구매했습니다.");
    }
}
