package lotto.view;

import camp.nextstep.edu.missionutils.*;
import lotto.LottoException;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static int readInt(){
        while(true){
            try{
                String line = Console.readLine();
                Validator.validateInteger(line);
                return Integer.parseInt(line);
            }catch (LottoException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static int readNatural(){
        while(true){
            try{
                int number = readInt();
                Validator.validateNatural(number);
                return number;
            } catch (LottoException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static List<Integer> readCommaSeperatedInt(){
        while(true){
            try{
                String line = Console.readLine();
                String[] tokens = line.split(",");
                return Arrays.stream(tokens)
                        .map(token->{
                            Validator.validateInteger(token);
                            int number = Integer.parseInt(token);
                            Validator.validateNatural(number);
                            return number;
                        }).collect(Collectors.toList());
            } catch (LottoException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
