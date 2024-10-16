package com.zeotop.assignment1.ruleenginewithast;
import java.util.HashMap;
import java.util.Map;

public class JSONObject {

    // Define an internal map to hold key-value pairs
    private Map<String, Object> data = new HashMap<>();

    // Method to evaluate rules based on ASTNode
    public boolean evaluateRule(ASTNode node, JSONObject data) {
        if (node == null) return true;

        switch (node.operator) {
            case "AND":
                return evaluateRule(node.left, data) && evaluateRule(node.right, data);
            case "OR":
                return evaluateRule(node.left, data) || evaluateRule(node.right, data);
            case "NOT":
                return !evaluateRule(node.left, data);
            default:
                return evaluateCondition(node.operand, data);
        }
    }
    private boolean evaluateCondition(String operand, JSONObject data) {
        if (operand.contains(">")) {
            String[] parts = operand.split(">");
            String key = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());
            return data.getInt(key) > value;
        }
        return false;
    }

    public int getInt(String key) {
        return (int) data.getOrDefault(key, 0);
    }

    public void put(String key, int value) {
        data.put(key, value);
    }

    public void put(String key, String value) {
        data.put(key, value);
    }
}

