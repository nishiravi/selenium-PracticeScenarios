package test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsClass {

	//@Test
	public void StremsTest()
	{
		ArrayList<String> names= new ArrayList();
		names.add("hi");
		names.add("grace");
		names.add("helo");
		names.add("helo");
		names.add("happy");
		names.add("face");
		
		Long a=names.stream().filter(s->s.startsWith("h")).count();;
		System.out.println(a);
		
	}
	//@Test
	public void StremsSort()
	{
		ArrayList<String> fames= new ArrayList();
		fames.add("hi");
		fames.add("grace");
		fames.add("helo");
		fames.add("helo");
		fames.add("happy");
		fames.add("face");
		System.out.println("the names having length more than 4");
		fames.stream().filter(s->(s.length()>4)).forEach(s->System.out.println(s));
		System.out.println("print names start with A and convert those names into lowercase and print only 1 value");
		Stream.of("Abc","TRU","YER","ADEE").filter(s->s.startsWith("A")).map(s->s.toLowerCase()).limit(1).forEach(s->System.out.println(s));
		System.out.println("Convert array to array list using streams sort the data in the array");
		List<String> numbers=Arrays.asList("Abc","TRU","YER","AAEE");
		numbers.stream().filter(s->s.startsWith("A")).sorted().forEach(s->System.out.println(s));
		
	}
	
	@Test
	public void streamCollect()
	{
		List<Integer> ls=Stream.of(44,16,48,100,9).sorted().collect(Collectors.toList());
		System.out.println("sorted list is below");
		for(int number:ls)
		{
			
			System.out.println(number);
		}
		List<Integer> a=Stream.of(3,58,74,74,96,1,1).distinct().sorted().collect(Collectors.toList());
		System.out.println("distinct and sorted number are below");
		for( int b:a)
		{
			System.out.println(b);
		}
		System.out.println("third index is "+a.get(2));
	}

	@Test
	public void concatstreams()
	{
		ArrayList<String> a=new ArrayList<>();
		a.add("hello");
		a.add("hi");
		a.add ("bye");
		a.stream().filter(s->s.startsWith("h")).map(s->s.toLowerCase()).sorted().forEach(s->System.out.println(s));
		List<String> c=Stream.of("hello","good","bad","zee").sorted().collect(Collectors.toList());
		// concat to list using stream
		Stream<String> data=Stream.concat(a.stream(),c.stream());
		data.distinct().forEach(data1->System.out.println(data1));
		// check if list has "ZEE"
		//boolean datapresent=data.anyMatch(f->f.equalsIgnoreCase("zee"));
		//Assert.assertTrue(datapresent);

	}
	
	}
	
	


