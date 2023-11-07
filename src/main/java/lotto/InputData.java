package lotto;

import java.util.List;

public class InputData {

    public List<String> lottoMake(String input){
        List<String> lottoNumber = List.of(input.split(","));
        return lottoNumber;
    }

}
