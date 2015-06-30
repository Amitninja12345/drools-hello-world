package org.jboss.rules;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ofbizian.drools.domain.Product;
import com.ofbizian.drools.domain.ShoppingCart;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShoppingCartRiskTest extends RulesTestBase{

  @Test
  public void test_EuroLowValue_shouldAccept() {
      compileAndLoadKieSession("com.ofbizian.drools.drl");

      Product product1 = new Product();
      product1.setCode("ASSET");
      product1.setValue(5.00);

      Product product11 = new Product();
      product11.setCode("ASSET");
      product11.setValue(10.00);

      Product product2 = new Product();
      product2.setCode("LIABILITY");
      product2.setValue(20.00);


      ArrayList<Product> items = new ArrayList<Product>();
      items.add(product1);
      items.add(product11);
      items.add(product2);

      ShoppingCart cart = new ShoppingCart();
      cart.setItems(items);

      int rules=fireAllRules(cart);
    
//    assertEquals("ACCEPT", order.getRiskStatus());
//    assertTrue(StringUtils.isEmpty(order.getRiskReason()));
//      assertEquals(2, rules);
  }



  
}
