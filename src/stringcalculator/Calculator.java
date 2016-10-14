package stringcalculator;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdOut;

public class Calculator
{
	
	public static int add(String text)
	{
		if(text.equals(""))
		{
			return 0;
		}
		else if(text.contains(",") || text.contains("\n") || text.startsWith("//"))
		{
			return sum(splitNumbers(text));
		}
		else return 1;
	}

	private static int toInt(String text)
	{
		return Integer.parseInt(text);
	}

	private static String[] splitNumbers(String text)
	{
		String stuff = "(,|\n)";
		String textWithoutStuff = text;
		
		if(text.startsWith("//"))
		{
			int startIndex = text.indexOf("//")  + 2;
			stuff = text.substring(startIndex, startIndex + 1);
			textWithoutStuff = text.substring(text.indexOf("\n") + 1);
		}
		
		return textWithoutStuff.split(stuff);
	}
	
	private static int sum(String[] numbers)
	{
		int total = 0;
		List<Integer> negNumbs = new ArrayList<Integer>();
		
		for(String number : numbers)
		{
			int intNumber = toInt(number);
			if(intNumber < 0)
			{
				negNumbs.add(intNumber);
			}
			else if(intNumber <= 1000)
			{
				total += intNumber;
			}
		}
		if(negNumbs.size() > 0)
		{
			throw new IllegalArgumentException("Negatives not allowed: " + negNumbs.toString().replace("[", "").replace("]", "").replace(" ", ""));
		}
		return total;
	}
	public static void main(String args[])
	{
		int numb = add("2,3");
		StdOut.print(numb);
	}
}