package com.ofbizian.drools;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.ofbizian.drools.standalone.HelloWorld;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.junit.Test;

public class HelloWorldTest {

    public static void main(String[] args) throws DroolsParserException, IOException {
        HelloWorldTest helloWorldTest = new HelloWorldTest();
        helloWorldTest.loadsFile();
    }

    @Test
    public void loadsFile() throws IOException, DroolsParserException {
        PackageBuilder packageBuilder = new PackageBuilder();
        InputStream resourceAsStream = getClass().getResourceAsStream("/com/ofbizian/drools/standalone/Sample.drl");
        Reader reader = new InputStreamReader(resourceAsStream);
        packageBuilder.addPackageFromDrl(reader);
        org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(rulesPackage);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");

        WorkingMemory workingMemory = ruleBase.newStatefulSession();
        workingMemory.insert(helloWorld);
        workingMemory.fireAllRules();
    }

}