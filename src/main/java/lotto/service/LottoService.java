package lotto.service;

import lotto.domain.Customer;
import lotto.domain.IssuingMachine;
import lotto.domain.Lucky;
import lotto.domain.ResultRepository;

public class LottoService {

    private Customer customer;
    private IssuingMachine issuingMachine;
    private Lucky lucky;
    private ResultRepository resultRepository=new ResultRepository();

    public LottoService(Customer customer, IssuingMachine issuingMachine, Lucky lucky){
        this.customer=customer;
        this.issuingMachine=issuingMachine;
        this.lucky=lucky;
    }

    public void start(){
        customer.pay();
    }
}
