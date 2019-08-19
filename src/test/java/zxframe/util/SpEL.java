package zxframe.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpEL {
	public Object $(String c) {
		return c;
	}
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		Map map=new HashMap();
		map.put("value1", 1);
		map.put("value2", "2");
		EvaluationContext context = new StandardEvaluationContext(map);
		int value1=(int)parser.parseExpression("get(\"value1\")").getValue(context);
		System.out.println(value1);
		boolean b=(boolean)parser.parseExpression("get(\"value1\") == 1 && get(\"value2\").toString().equals(\"2\")").getValue(context);
		System.out.println(b);
		boolean c=(boolean)parser.parseExpression("get(\"value2\") != null").getValue(context);
		System.out.println(c);
		
		SpEL sl=new SpEL();
		String s=(String)parser.parseExpression("$(\"test\")").getValue(sl);
		System.out.println(s);
		//去除;{}
	}
}
