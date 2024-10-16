package com.zeotop.assignment1.ruleenginewithast;

import java.util.List;

public class ASTNode {
String operator;   
String operand;    
ASTNode left;      
ASTNode right;     

public ASTNode(String operator, ASTNode left, ASTNode right) {
this.operator = operator;
this.left = left;
this.right = right;
}

public ASTNode(String operand) {
this.operand = operand;
}


}

