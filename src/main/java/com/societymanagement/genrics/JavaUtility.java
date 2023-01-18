package com.societymanagement.genrics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandom() {
	Random rand=new Random();
	int value = rand.nextInt(20);
	return value;
}

public String getCurrentDate() {
	Date d=new Date();
	String date = d.toString();
	return date;
	
}
public String getSystemDateAndTimeFormat() {
	SimpleDateFormat dateFormat=new SimpleDateFormat("DD-MM-yyyy HH:mm:ss");
	Date systemDate=new Date();
	String dateAndTime =dateFormat.format(systemDate);
	return dateAndTime.replaceAll(":", "-");
}
}