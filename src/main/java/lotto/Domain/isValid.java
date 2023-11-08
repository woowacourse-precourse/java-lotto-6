package lotto.Domain;

public class isValid {

    public boolean isValidNames(String input){
        System.out.println("hello");
        boolean isNumeric = input.matches("[+-]?\\d*(\\.\\d+)?");
        /*try {
            Integer.parseInt(input);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("[ERROR]");
            return false;
        }*/
        return isNumeric;
    }
}
