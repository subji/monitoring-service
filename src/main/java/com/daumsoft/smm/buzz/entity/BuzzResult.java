package com.daumsoft.smm.buzz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(
  // BuzzResult 부분이 중요하다.
  // 이 부분은 반드시 엔티티 객체명과 같게 해야한다.
  // NamedQuery 에서 List 로 받아오고자 할때는 new 로 객체를 생성해주어야한다.
  // 따라서 필요한 프로퍼티를 지정할수있으므로 lombok 의 어노테이션을 활용하자(builder 패턴)
  name = "BuzzResult.findSumByPeriod",
  query = "SELECT new com.daumsoft.smm.buzz.entity.BuzzResult(b.channel, b.basisDate, SUM(b.documentCount) AS documentCount) " + 
          "FROM BuzzResult b " + 
          "WHERE b.basisDate BETWEEN :startDate AND :endDate " + 
          "GROUP BY (b.basisDate, b.channel) " + 
          "ORDER BY b.channel, b.basisDate ASC"
)
@IdClass(BuzzResultPK.class)
@Table(name = "TM_BUZZ_RSLT")
public class BuzzResult implements Serializable {

  // @Column 의 경우 DB 에서 대소문자를 구분하므로 DB 컬럼 이름과 다를경우 반드시 name 을 정의해주어야한다.

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "RGST_DT")
  private String registerDate;

  @Id
  @Column(name = "BASIS_DT")
  private String basisDate;

  @Id
  @Column(name = "CHANNEL")
  private String channel;

  @Column(name = "DOC_COUNT")
  private Long documentCount;

  public BuzzResult ()  {}

  public BuzzResult (String channel, String basisDate, Long documentCount)  {
    this.channel = channel;
    this.basisDate = basisDate;
    this.documentCount = documentCount;
  }

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

  public Long getDocumentCount() {
    return documentCount;
  }

  public void setDocumentCount(Long documentCount) {
    this.documentCount = documentCount;
  }

  /**
   * toString 함수를 Override 하는 이유는 해당 객체의 값에 대한 디버깅과 단위테스트에 도움이 되기 위해 작성한다.
   */
  @Override
  public String toString () {
    return "BuzzResult [registerDate=" + registerDate + ", " + "basisDate=" + basisDate + ", " + "channel=" + channel + ", " + "documentCount=" + documentCount + "]";
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

    BuzzResult other = (BuzzResult) obj;

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

}