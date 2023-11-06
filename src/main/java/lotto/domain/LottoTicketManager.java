package lotto.domain;

import lotto.validator.LottoTicketValidator;

public class LottoTicketManager {

    public LottoTicketManager(){
    }

    public Integer countTickets(String price) {
        return convertPrice(price)/1000 ;
    }

    private Integer convertPrice(String price){
        return Integer.parseInt(price);
    }

}
