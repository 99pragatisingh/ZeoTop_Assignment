package com.zeotop.assignment1.ruleenginewithast;

import java.util.List;

public class RuleEngine {
    public ASTNode createRule(String ruleString) {

// Here, you would analyze the input ruleString like "(age > 30 AND department = 'Sales')"

return parseRule(ruleString);
}

private ASTNode parseRule(String ruleString) {
if (ruleString.contains("AND")) {
String[] parts = ruleString.split("AND");
return new ASTNode("AND", parseRule(parts[0]), parseRule(parts[1]));
}
if (ruleString.contains("OR")) {
String[] parts = ruleString.split("OR");
return new ASTNode("OR", parseRule(parts[0]), parseRule(parts[1]));
}
return new ASTNode(ruleString.trim());
}

public ASTNode combineRules(List<ASTNode> rules) {
	ASTNode combined = null;
	//ASTNode combined = rules.get(0);
    for (int i = 1; i < rules.size(); i++) {
        combined = new ASTNode("AND", combined, rules.get(i));
    }
    return combined;

}

private boolean evaluateCondition(String operand, JSONObject data) {
    // Example: For "age > 30" you would parse and check:
    if (operand.contains(">")) {
        String[] parts = operand.split(">");
        String key = parts[0].trim();
        int value = Integer.parseInt(parts[1].trim());
        return data.getInt(key) > value;
    }
    return false;
}

public boolean evaluateRule(ASTNode combinedRule, JSONObject jsonData) {
	// TODO Auto-generated method stub
	return false;
}


}