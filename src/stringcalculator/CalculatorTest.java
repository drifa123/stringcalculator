package stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest
{
	public static void main(String args[])
	{
		org.junit.runner.JUnitCore.main("stringcalculator");
	}

	@Test
	public void testEmptyString()
	{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber()
	{
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers()
	{
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers()
	{
		assertEquals(6, Calculator.add("1,2,3"));
	}
	@Test
	public void testStuff()
	{
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testNegative()
	{
		assertEquals(5, Calculator.add("-1,2,3"));
	}
	@Test
	public void testBig()
	{
		assertEquals(5, Calculator.add("1002,2,3"));
	}
	@Test
	public void testMoreStuff()
	{
		assertEquals(3, Calculator.add("//;\n1;2"));
	}


}