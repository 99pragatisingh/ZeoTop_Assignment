package com.zeotop.assignment1.ruleenginewithast;

import java.util.Arrays;
import java.util.List;

public class Main {

	 public static void main(String[] args) {
		    RuleEngine engine = new RuleEngine();

		    ASTNode rule1 = engine.createRule("(age > 30 AND department = 'Sales')");
		    ASTNode rule2 = engine.createRule("(age < 25 AND department = 'Marketing')");
		    List<ASTNode> rules = Arrays.asList(rule1, rule2);
		    ASTNode combinedRule = engine.combineRules(rules);
		    JSONObject jsonData = new JSONObject();
		    jsonData.put("age", 32);
		    jsonData.put("department", "Sales");

		    boolean result = engine.evaluateRule(combinedRule, jsonData);
		    System.out.println("Evaluation result: " + result);
		}


}
