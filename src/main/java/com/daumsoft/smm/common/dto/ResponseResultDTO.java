package com.daumsoft.smm.common.dto;

public class ResponseResultDTO {

  private int status;
  private String message;
  private Object data;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "ResponseResult [data=" + data + ", message=" + message + ", status=" + status + "]";
  }

}