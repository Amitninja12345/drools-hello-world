package com.ofbizian.drools.agendagroup;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.junit.Test;

public class SalienceTest {

    @Test
    public void loadsFile() throws IOException, DroolsParserException {
        PackageBuilder packageBuilder = new PackageBuilder();
        InputStream resourceAsStream = Object.class.getResourceAsStream("/SalienceRule.drl");
        Reader reader = new InputStreamReader(resourceAsStream);
        packageBuilder.addPackageFromDrl(reader);
        org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(rulesPackage);

        Person person = new Person("Hello", "World");

        WorkingMemory workingMemory = ruleBase.newStatefulSession();
        workingMemory.insert(person);
        workingMemory.fireAllRules();
    }

}