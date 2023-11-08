package lotto;

public abstract class Numbers<T> {
    protected boolean validate(T t) {
        boolean isIncorret = false;

        try {
            checkValidity(t);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isIncorret = true;
        }

        return isIncorret;
    }

    protected abstract void checkValidity(T v);
}
