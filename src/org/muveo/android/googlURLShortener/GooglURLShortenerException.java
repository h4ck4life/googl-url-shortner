package org.muveo.android.googlURLShortener;
 
public class GooglURLShortenerException extends Exception {

	private static final long serialVersionUID = -8042108451646368993L;
	private String message = null;
 
    public GooglURLShortenerException() {
        super();
    }
 
    public GooglURLShortenerException(String message) {
        super(message);
        this.message = message;
    }
 
    public GooglURLShortenerException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}