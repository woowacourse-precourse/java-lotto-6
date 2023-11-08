package lotto.service;

import lotto.utils.ErrorMessageUtil;

abstract class CreateService {
    abstract public Object createObject(final Object... inputs);

    public Object create(final Object... inputs) {
        Object object = null;
        boolean flag = false;

        while (!flag) {
            try {
                object = createObject(inputs);
                flag = true;
            } catch (IllegalArgumentException exception) {
                System.out.print(ErrorMessageUtil.getOutputErrorMessage(exception));
            }
        }

        return object;
    }
}
