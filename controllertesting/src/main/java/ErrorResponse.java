public class ErrorResponse implements Response {

    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request request, Exception e) {
        originalException = e;
        originalRequest = request;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public Exception getOriginalException() {
        return originalException;
    }
}
