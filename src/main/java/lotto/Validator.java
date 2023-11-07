package lotto;

public class Validator {
    protected int validateStringIsInt(String subjectString) throws IllegalArgumentException{
        int validatedInt;
        try{
            validatedInt = Integer.parseInt(subjectString);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return validatedInt;
    }
}
