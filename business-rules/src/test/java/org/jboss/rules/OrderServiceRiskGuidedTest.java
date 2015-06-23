package org.jboss.rules;

import com.ofbizian.drools.domain.Country;
import com.ofbizian.drools.domain.Order;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrderServiceRiskGuidedTest extends RulesTestBase{

    @Test
    public void test_EuroCountriesNeedRiskChecks() {
        compileAndLoadKieSession("com.ofbizian.drools.xls");

        loadKieSession("xlsKieBase.session");
        Order order=new Order();
        order.setId("1");
        order.setCountry(Country.GBR);
        int rules=fireAllRules(order);
        assertEquals(true, order.isRiskCheck());
        assertEquals(1, rules);
    }

    @Test
    public void test_NonEuroCountriesDontNeedRiskChecks() {
        loadKieSession("xlsKieBase.session");
        Order order=new Order();
        order.setId("1");
        order.setCountry(Country.AFG);

        int rules=fireAllRules(order);
        assertEquals(false, order.isRiskCheck());
        assertEquals(0, rules);
    }
}
