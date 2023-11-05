package lotto.service.convert;

public class ConvertService {
    public ConvertService(){}

    public int convertStringToNumbers(String number){
        int num = -1;
        try {
            num = Integer.parseInt(number);
            if (num % 1000 != 0) {
                throw new IllegalArgumentException("");
            }
        }catch (NumberFormatException e){
            System.out.println("");
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return num;
    }
}
