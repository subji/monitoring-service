package com.daumsoft.smm.buzz.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BuzzResultPK implements Serializable {

  private static final long serialVersionUID = 1L;

  private String registerDate;
  private String basisDate;
  private String channel;
  
  public BuzzResultPK () {}

  public String getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(String registerDate) {
    this.registerDate = registerDate;
  }

  public String getBasisDate() {
    return basisDate;
  }

  public void setBasisDate(String basisDate) {
    this.basisDate = basisDate;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((basisDate == null) ? 0 : basisDate.hashCode());
    result = prime * result + ((channel == null) ? 0 : channel.hashCode());
    result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)  {
      return true;
    }

    if (obj == null)  {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    BuzzResultPK other = (BuzzResultPK) obj;

    if (basisDate == null) {
      if (other.basisDate != null)  {
        return false;
      }
    } else if (!basisDate.equals(other.basisDate))  {
      return false;
    }

    if (channel == null) {
      if (other.channel != null)  {
        return false;
      }
    } else if (!channel.equals(other.channel))  {
      return false;
    }

    if (registerDate == null) {
      if (other.registerDate != null) {
        return false;
      }
    } else if (!registerDate.equals(other.registerDate))  {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "BuzzResultPK [basisDate=" + basisDate + ", channel=" + channel + ", registerDate=" + registerDate + "]";
  }

}