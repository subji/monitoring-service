package com.daumsoft.smm.jpa;

import java.util.List;

import com.daumsoft.smm.buzz.entity.BuzzResult;
import com.daumsoft.smm.buzz.repository.BuzzResultRepository;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BuzzResultTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private BuzzResultRepository buzzResultRepository;

  @Test
  public void testBuzzResultRepository_등록날짜기준_채널별_버즈량_합계_시작날짜_파라미터가_null_테스트() {
    // Given
    String startDate = null;
    String endDate = "20200131";

    // When
    List<BuzzResult> buzzResultList = buzzResultRepository.findSumByPeriod(startDate, endDate);

    // Then
    try {
      buzzResultList.get(0);
      // Exception 이 Throw 되지 않을때 테스트가 실패하도록 하기위해 항상 Assert.fail() 을 추가해야 한다.
      Assert.fail("Should throw IndexOutOfBoundException");
    } catch (IndexOutOfBoundsException e) {
      Assert.assertEquals("Index: 0, Size: 0", e.getMessage());
    }
  }

  @Test
  public void testBuzzResultRepository_등록날짜기준_채널별_버즈량_합계_종료날짜_파라미터가_null_테스트() {
    // Given
    String startDate = "20200101";
    String endDate = null;

    // When
    List<BuzzResult> buzzResultList = buzzResultRepository.findSumByPeriod(startDate, endDate);

    // Then
    try {
      buzzResultList.get(0);
      // Exception 이 Throw 되지 않을때 테스트가 실패하도록 하기위해 항상 Assert.fail() 을 추가해야 한다.
      Assert.fail("Should throw IndexOutOfBoundException");
    } catch (IndexOutOfBoundsException e) {
      Assert.assertEquals("Index: 0, Size: 0", e.getMessage());
    }
  }

  @Test
  public void testBuzzResultRepository_등록날짜기준_채널별_버즈량_합계_전체_파라미터가_null_테스트() {
    // Given
    String startDate = null;
    String endDate = null;

    // When
    List<BuzzResult> buzzResultList = buzzResultRepository.findSumByPeriod(startDate, endDate);

    // Then
    try {
      buzzResultList.get(0);
      // Exception 이 Throw 되지 않을때 테스트가 실패하도록 하기위해 항상 Assert.fail() 을 추가해야 한다.
      Assert.fail("Should throw IndexOutOfBoundException");
    } catch (IndexOutOfBoundsException e) {
      Assert.assertEquals("Index: 0, Size: 0", e.getMessage());
    }
  }

  @Test
  public void testBuzzResultRepository_등록날짜기준_채널별_버즈량_합계_테스트() {
    // Given
    String startDate = "20200101";
    String endDate = "20200131";

    // When
    List<BuzzResult> buzzResultList = buzzResultRepository.findSumByPeriod(startDate, endDate);

    // Then
    BuzzResult buzzResult = buzzResultList.get(0);
    Assert.assertThat(buzzResult.getChannel(), Is.is("blog"));
    Assert.assertThat(buzzResult.getBasisDate(), Is.is("20200101"));
    Assert.assertThat(buzzResult.getDocumentCount(), Is.is(6558545L));
  }
}