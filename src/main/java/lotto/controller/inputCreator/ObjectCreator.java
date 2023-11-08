package lotto.controller.inputCreator;

public interface ObjectCreator<T, U> {
    T createObjectByInput(U arg);
}
