package com.minor.autocode;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public static void main(String[] args) {
    	Table<Integer, Integer, Person> personTable = HashBasedTable.create();
    	personTable.put(1, 20, new Person(1,"apple","apsw"));
    	personTable.put(2, 30, new Person(1,"banana","bpsw"));
    	personTable.put(3, 40, new Person(1,"cat","cpsw"));
    	personTable.put(4, 50, new Person(1,"doggy","dpsw"));
    	
    	
    	System.out.println(personTable.row(1));
    	System.out.println(personTable.row(2));
    	System.out.println(personTable.row(3));
    	System.out.println(personTable.row(4));
    	System.out.println(personTable.column(20));
    	System.out.println(personTable.column(30));
    	System.out.println(personTable.column(40));
    	System.out.println(personTable.column(50));
    	
    	System.out.println();
    	
    }
    
    static class Person{
    	int id;
    	String name;
    	String psw;
    	
    	public Person(){
    	}
    	public Person(int id, String name, String psw){
    		this.id = id;
    		this.name = name;
    		this.psw = psw;
    	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPsw() {
			return psw;
		}
		public void setPsw(String psw) {
			this.psw = psw;
		}
    	
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
		}
		
    }
    
    static class NotNullStringStyle extends ToStringStyle{
    	public void append(final StringBuffer buffer, final String fieldName, final Object value, final Boolean fullDetail) {
            if(value!=null){
            	super.append(buffer, fieldName, value, fullDetail);
            }
        }
    }
}
