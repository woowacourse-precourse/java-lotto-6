package lotto;

public class Validator {
    protected Integer validateStringIsInt(String subjectString) throws IllegalArgumentException{
        int validatedInt;
        try{
            validatedInt = Integer.parseInt(subjectString);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return validatedInt;
    }
}
