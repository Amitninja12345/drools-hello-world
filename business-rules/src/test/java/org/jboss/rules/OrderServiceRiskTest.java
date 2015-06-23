package org.jboss.rules;

import com.ofbizian.drools.domain.Country;
import com.ofbizian.drools.domain.Order;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderServiceRiskTest extends RulesTestBase{

  @Test
  public void test_EuroLowValue_shouldAccept() {
    compileAndLoadKieSession("com.ofbizian.drools.dsl");
    
      Order order=new Order();
      order.setId("1");
      order.setCountry(Country.GBR);
      order.setAmount(50.00);

    int rules=fireAllRules(order);
    
    assertEquals("ACCEPT", order.getRiskStatus());
    assertTrue(StringUtils.isEmpty(order.getRiskReason()));
    assertEquals(1, rules);
  }



  @Test
  public void test_EuroHighValue_shouldRefer() {
    loadKieSession("dslKieBase.session");
      Order order=new Order();
      order.setId("1");
      order.setCountry(Country.GBR);
      order.setAmount(1200.00);


      int rules=fireAllRules(order);

    assertEquals("REFER", order.getRiskStatus());
//    assertEquals("ORDER AMOUNT TOO HIGH", order.getRiskReason());
    assertEquals(1, rules);
  }
  
}
