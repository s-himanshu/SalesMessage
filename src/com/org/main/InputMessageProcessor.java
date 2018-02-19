package com.org.main;
/**
 * Created by Himanshu Singh on 18/02/2018.
 *
 * Class Name: InputMessageProcessor
 * This class has the Main method from where application gets executed.
 * Needs a file as input which contains the sales message details in the conf folder.
 * A report is generated and displayed on the console. 
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;

import com.org.bussinessobjects.Sale;


public class InputMessageProcessor {

	public static void main(String[] args) {
		// Initiate the sale object
		Sale sale = new Sale();		
		try {
			String line;
			//Read the input file from conf folder
			BufferedReader inputTxtFile = new BufferedReader(new FileReader("conf/input.txt"));
			while((line = inputTxtFile.readLine()) != null) {
				// process message for each sale notification
				sale.processNotification(line);
				// Log the report
				// Report only generates after every 10th iteration and stops on 50th iteration and pauses for
				// 2 seconds.
				sale.log.report();
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

}