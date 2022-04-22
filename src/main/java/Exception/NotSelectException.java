package Exception;

import java.beans.ExceptionListener;

public class NotSelectException implements ExceptionListener {
    @Override
    public void exceptionThrown(Exception e) {
        System.err.println("Not select row exception.");
    }
}
