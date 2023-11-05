package lotto.global.exception;

import lotto.global.exception.base.DefaultException;

public class GlobalException extends DefaultException {

    public GlobalException(GlobalError error) {
        super(error);
    }
}
