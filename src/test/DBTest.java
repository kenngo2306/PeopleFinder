package test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import main.DB;
import main.Person;

import org.junit.Test;





public class DBTest
{

	@Test
	public void testFindPeople()
	{
		DB db = new DB();
		System.out.println("in test");
		ArrayList<Person> people = db.findPeople("HELP");
		
		for(Person person: people)
		{
			System.out.println(person.getLastName() +" "+ person.getCompanyName());
		}
	}
	
//	@Test
	public void testFindPerson()
	{
		DB db = new DB();
		System.out.println("in test");
		Person person = db.findPersonWithId(2756);
		
		System.out.println(person.getId());
		System.out.println(person.getFirstName());
		System.out.println(person.getCompanyName());
	}

}
