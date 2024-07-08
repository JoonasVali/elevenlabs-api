package net.andrewcpu.elevenlabs.util;
public class RequestResult<T> {
  private final T result;
  private final String requestId;
  public RequestResult(T result, String requestId) {
    this.result = result;
    this.requestId = requestId;
  }


  public T getResult() {
    return result;
  }

  public String getRequestId() {
    return requestId;
  }
}
