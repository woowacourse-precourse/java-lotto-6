package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputData inputdata=new InputData();
        OutputData outputData=new OutputData();

        inputdata.inputPrice();
        outputData.printTickets(inputdata.amount);
        inputdata.inputNumbers();
        Lotto lotto=new Lotto(InputData.number_list);
        inputdata.inputBonusNumber();
        outputData.winStats(outputData.tickets_count);

    }
}
